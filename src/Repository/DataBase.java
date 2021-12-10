package Repository;

import Domain.Model.Entity;
import Presentation.AddScene.AddSceneController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class DataBase {
    private final String LOGIN = "root";
    private final String PASSWORD = "Fedorenko20";
    private final String DB_NAME = "mydb";
    private final String HOST = "localhost";
    private final String PORT = "3306";

    private Connection connection = null;

    public DataBase(){
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connStr, LOGIN, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public String handleStatement(String sql){
        sql = sql.trim().split(";")[0];
        String command = sql.trim().toLowerCase(Locale.ROOT).split(" ")[0];
        try {
            if(command.equals("select")) {
                Statement statement = connection.createStatement();
                ResultSet res = statement.executeQuery(sql);
                DefaultTableModel model  = resultSetToTableModel(res);
                JOptionPane.showMessageDialog(null, new JScrollPane(new JTable(model)));
                return "successful " + command;
            } else if (command.equals("insert") || command.equals("delete") || command.equals("update")){
                PreparedStatement prSt = connection.prepareStatement(sql);
                prSt.executeUpdate();
                return "successful " + command;
            } else
                return "Unknown command or you have no permission to use this command";
        } catch (SQLException e) {
            return e.toString();
        }
    }

    public void find(Entity table, String word) throws SQLException {
        String sql = "SELECT * FROM " +
                table.getClass().getSimpleName().toLowerCase(Locale.ROOT) +
                " WHERE " +
                table.getListOfAttributes().get(0) +
                " LIKE '%" +
                word +
                "%'";

        ArrayList<String> columns = table.getListOfAttributes();
        for (int i = 1; i < columns.size(); i++){
            sql += "OR " + columns.get(i) + " LIKE '%" + word + "%'";
        }
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        DefaultTableModel model = resultSetToTableModel(res);
        JOptionPane.showMessageDialog(null, new JScrollPane(new JTable(model)));

    }

    public void remove(Entity table, String id){
        String sql = "DELETE FROM " +
                table.getClass().getSimpleName().toLowerCase(Locale.ROOT) +
                " WHERE " + table.getListOfAttributes().get((0)) + " = " + id;

        PreparedStatement prSt;
        try {
            prSt = connection.prepareStatement(sql);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            AddSceneController.showAlert("SQL syntax error", e.toString());
        }
    }

    public void insert(String tableName, String values, String names){
        String sql = "INSERT INTO " + tableName + " (" + names + ")" + " VALUES (" + values + ")";

        PreparedStatement prSt;
        try {
            prSt = connection.prepareStatement(sql);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            AddSceneController.showAlert("SQL syntax error", e.toString());
        }
    }

    public ArrayList<Entity> getTable(Class<? extends Entity> classEntity){
        ArrayList<Entity> items = null;
        try {
            Statement statement = connection.createStatement();
            Object ob = classEntity.getDeclaredConstructor().newInstance();
            Method method = classEntity.getMethod("getCountOfParams");
            Integer countOfAttributes = (Integer)method.invoke(ob);
            String tableName = classEntity.getSimpleName().toLowerCase(Locale.ROOT);
            String sql = "SELECT * FROM " + tableName;
            ResultSet res = statement.executeQuery(sql);
            items = new ArrayList<>();

            while(res.next()) {
                ArrayList<String> params = new ArrayList<>();
                for (int i = 0; i < countOfAttributes; i++) {
                    params.add(res.getString(i + 1));
                }
                Entity item = classEntity.getDeclaredConstructor().newInstance();
                Method method2 = classEntity.getMethod("setParams", params.getClass());
                item = (Entity) method2.invoke(item, params);
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    private DefaultTableModel resultSetToTableModel(ResultSet row) throws SQLException {

        ResultSetMetaData meta= row.getMetaData();
        DefaultTableModel model = new DefaultTableModel();

        String[] cols = new String[meta.getColumnCount()];

        for(int i = 0; i < cols.length; ++i)
            cols[i] = meta.getColumnLabel(i + 1);

        model.setColumnIdentifiers(cols);

        while(row.next()) {
            Object[] data = new Object[cols.length];

            for(int i = 0; i < data.length; ++i)
                data[i] = row.getObject(i+1);

            model.addRow(data);
        }
        return model;
    }
}
package sample;

import Domain.Model.Documents;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView<Documents> tvDocuments;
    @FXML
    private TableColumn<Documents, Integer> colDocCode;
    @FXML
    private TableColumn<Documents, Date> colDate;
    @FXML
    private TableColumn<Documents, Integer> colSupCode;
    @FXML
    private TableColumn<Documents, Integer> colRecipCode;
    @FXML
    private TableColumn<Documents, Integer> colCodeOfStuff;
    @FXML
    private TableColumn<Documents, Integer> colCodeOfProd;
    @FXML
    private TableColumn<Documents, Integer> colDocTypeCode;
    @FXML
    private TableColumn<Documents, Integer> colValueOfProd;
    @FXML
    private TableColumn<Documents, Integer> colCount;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    public void insertBT(ActionEvent event){


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showDocuments();
    }

    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "Fedorenko20");
            return conn;
        }catch (Exception ex){
            System.out.println("Error " + ex.getMessage());
            return null;
        }
    }

    public ObservableList<Documents> getDocumentsList(){
        ObservableList<Documents> documentsList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM mydb.documents";
        Statement st;
        ResultSet rs;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Documents documents;
            while(rs.next()){
                documents = new Documents(rs.getInt("DocumentCode"),
                        rs.getDate("DealDate"),
                        rs.getInt("SupplierCode"),
                        rs.getInt("RecipientCode"),
                        rs.getInt("CodeOfStuff"),
                        rs.getInt("CodeOfProduct"),
                        rs.getInt("DocTypeCode"),
                        rs.getInt("ValueOfProduct"),
                        rs.getInt("Count"));
                documentsList.add(documents);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return documentsList;
    }

    public void showDocuments(){
        ObservableList<Documents> list = getDocumentsList();

        colDocCode.setCellValueFactory(new PropertyValueFactory<Documents, Integer>("DocumentCode"));
        colDate.setCellValueFactory(new PropertyValueFactory<Documents, Date>("Date"));
        colSupCode.setCellValueFactory(new PropertyValueFactory<Documents, Integer>("SupplierCode"));
        colRecipCode.setCellValueFactory(new PropertyValueFactory<Documents, Integer>("RecipientCode"));
        colCodeOfStuff.setCellValueFactory(new PropertyValueFactory<Documents, Integer>("CodeOfStuff"));
        colCodeOfProd.setCellValueFactory(new PropertyValueFactory<Documents, Integer>("CodeOfProduct"));
        colDocTypeCode.setCellValueFactory(new PropertyValueFactory<Documents, Integer>("DocTypeCode"));
        colValueOfProd.setCellValueFactory(new PropertyValueFactory<Documents, Integer>("ValueOfProduct"));
        colCount.setCellValueFactory(new PropertyValueFactory<Documents, Integer>("Count"));

        tvDocuments.setItems(list);
    }
}

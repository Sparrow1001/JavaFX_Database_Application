package Presentation.MainWindow;

import Domain.Model.*;
import Presentation.AddScene.AddSceneController;
import Repository.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

public class MainController {

    @FXML
    private TableView<Entity> tableView;
    @FXML
    private Text textDocuments;
    @FXML
    private Text textCounter;
    @FXML
    private Text textDocumentType;
    @FXML
    private Text textPositions;
    @FXML
    private Text textRecipients;
    @FXML
    private Text textStuff;
    @FXML
    private Text textProducts;
    @FXML
    private Text textSuppliers;
    @FXML
    private TextField tfSearch;
    public tableController tableController;

    @FXML
    public void initialize(){
        this.tableController = new tableController();
        textDocuments.setOnMouseClicked(new TextClickHandler(textDocuments));
        textCounter.setOnMouseClicked(new TextClickHandler(textCounter));
        textDocumentType.setOnMouseClicked(new TextClickHandler(textDocumentType));
        textPositions.setOnMouseClicked(new TextClickHandler(textPositions));
        textRecipients.setOnMouseClicked(new TextClickHandler(textRecipients));
        textStuff.setOnMouseClicked(new TextClickHandler(textStuff));
        textProducts.setOnMouseClicked(new TextClickHandler(textProducts));
        textSuppliers.setOnMouseClicked(new TextClickHandler(textSuppliers));
    }

    class TextClickHandler implements EventHandler<Event> {
        private final String tableName;

        TextClickHandler(Text text){
            this.tableName = text.getText();
        }

        @Override
        public void handle(Event event) {
            tableController.switchCurrentTable(this.tableName);
        }
    }

    @FXML
    public void onClickInsert(){
        try {
            FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("Presentation/AddScene/addScene.fxml"));
            Parent root = loader.load();

            AddSceneController controller = loader.getController();
            controller.setAttributes(tableController.currentTable);
            controller.setMainController(this);

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(tableView.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onClickFind(){
        String word = tfSearch.getText().trim().toLowerCase(Locale.ROOT);
        if(word.isEmpty())
            AddSceneController.showAlert("Input error", "Field cannot be empty");
        else {
            try {
                tableController.searchInTable(word);
            } catch (SQLException e) {
                AddSceneController.showAlert("SQL exception", "SQL exception");
            }
        }
    }

    @FXML
    public void onClickRefreshMenuItem(){
        tableController.refreshTable();
    }

    @FXML
    public void onClickTerminal(){
        try {
            FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("Presentation/TerminalWindow/terminalScene.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(tableView.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class tableController {
        ObservableList<Entity> data;
        private Entity currentTable;
        private DataBase database;

        public tableController(){
            database = new DataBase();
            switchCurrentTable("Documents");
            setTableRowFactory();
        }

        public void searchInTable(String word) throws SQLException {
            database.find(currentTable, word);
        }

        public void setTableRowFactory(){
            tableView.setRowFactory(tableView->{
                TableRow<Entity> row = new TableRow<>();
                row.emptyProperty().addListener((obs, wasEmpty, isEmpty) -> {
                    if (!isEmpty) {
                        ContextMenu contextMenu = new ContextMenu();
                        MenuItem removeItem = new MenuItem("Delete");

                        Entity item = row.getItem();
                        removeItem.setOnAction(event -> {
                            database.remove(item, item.getPrimaryKey().toString());
                            refreshTable();
                        });

                        contextMenu.getItems().add(removeItem);
                        row.setContextMenu(contextMenu);
                    }
                });
                return row;
            });
        }

        public void switchCurrentTable(String name){
            switch (name) {
                case "Documents":
                    currentTable = new Documents();
                    break;
                case "Counter":
                    currentTable = new Counter();
                    break;
                case "DocumentType":
                    currentTable = new DocumentType();
                    break;
                case "Positions":
                    currentTable = new Positions();
                    break;
                case "Products":
                    currentTable = new Products();
                   break;
                case "Recipients":
                    currentTable = new Recipients();
                    break;
                case "Stuff":
                    currentTable = new Stuff();
                    break;
                case "Suppliers":
                    currentTable = new Suppliers();
                    break;
            }
            refreshTable();
        }

        public void refreshTable(){
            tableView.getItems().clear();
            tableView.getColumns().clear();
            data =  FXCollections.observableArrayList(database.getTable(currentTable.getClass()));
            ArrayList<String> attributes = currentTable.getListOfAttributes();
            for (String attribute : attributes){
                TableColumn <Entity, Object> column = new TableColumn<>(attribute);
                column.setCellValueFactory(new PropertyValueFactory<>(attribute));
                tableView.getColumns().add(column);
            }
            tableView.setItems(data);
        }
    }

}

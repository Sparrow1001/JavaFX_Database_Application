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
    private Text textContract;
    @FXML
    private Text textCounter;
    @FXML
    private Text textEmploee;
    @FXML
    private Text textEquipment;
    @FXML
    private Text textMaterials;
    @FXML
    private Text textOrders;
    @FXML
    private Text textProduction;
    @FXML
    private Text textProducts;
    @FXML
    private Text textProfession;
    @FXML
    private Text textStorage;
    @FXML
    private Text textSuppliers;
    @FXML
    private TextField tfSearch;
    public tableController tableController;

    @FXML
    public void initialize(){
        this.tableController = new tableController();
        textContract.setOnMouseClicked(new TextClickHandler(textContract));
        textCounter.setOnMouseClicked(new TextClickHandler(textCounter));
        textEmploee.setOnMouseClicked(new TextClickHandler(textEmploee));
        textEquipment.setOnMouseClicked(new TextClickHandler(textEquipment));
        textMaterials.setOnMouseClicked(new TextClickHandler(textMaterials));
        textOrders.setOnMouseClicked(new TextClickHandler(textOrders));
        textProduction.setOnMouseClicked(new TextClickHandler(textProduction));
        textProducts.setOnMouseClicked(new TextClickHandler(textProducts));
        textProfession.setOnMouseClicked(new TextClickHandler(textProfession));
        textStorage.setOnMouseClicked(new TextClickHandler(textStorage));
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
            FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("Presentation/TerminalScene/terminalScene.fxml"));
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
            switchCurrentTable("materials");
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
                case "contract":
 //                   currentTable = new Contract();
                    break;
                case "counter":
 //                   currentTable = new Counter();
                    break;
                case "emploee":
  //                  currentTable = new Emploee();
                    break;
                case "equipment":
 //                   currentTable = new Equipment();
                    break;
                case "materials":
  //                  currentTable = new Materials();
                   break;
                case "orders":
  //                  currentTable = new Orders();
                    break;
                case "production":
  //                  currentTable = new Production();
                    break;
                case "products":
    //                currentTable = new Products();
                    break;
                case "profession":
 //                   currentTable = new Profession();
                    break;
                case "storage":
   //                 currentTable = new Storage();
                    break;
                case "suppliers":
     //               currentTable = new Suppliers();
                    break;
            }
    //        refreshTable();
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

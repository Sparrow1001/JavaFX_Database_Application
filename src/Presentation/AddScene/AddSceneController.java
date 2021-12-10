package Presentation.AddScene;

import Domain.Model.Entity;
import Presentation.MainWindow.MainController;
import Repository.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Locale;

public class AddSceneController {

    private Entity table;
    private ArrayList<String> attributes;
    private MainController mController;
    @FXML
    private HBox hBox;

    @FXML
    public void initialize(){

    }

    public void setAttributes(Entity entity){
        this.table = entity;
        this.attributes = entity.getListOfAttributes();
        for(String attribute : attributes){
            TextField tf = new TextField();
            tf.setPromptText(attribute);
            tf.setPrefWidth(800);
            hBox.getChildren().add(tf);
        }
    }

    public void setMainController(MainController controller){
        this.mController = controller;
    }

    @FXML
    public void onClickApplyButton(){
        String values = "";
        String names = "";
        for (Object tf : hBox.getChildren()){
            TextField t = (TextField) tf;
            if (t.getText().isEmpty()) {
//                showAlert("Input not valid", "Field cannot be empty.");
                continue;
            } else {
                    names += t.getPromptText() + ", ";
                    values += "'" + t.getText().trim() + "', ";
                }
        }
        values = values.substring(0, values.length() - 2);
        names = names.substring(0, names.length() - 2);
        DataBase database = new DataBase();
        database.insert(table.getClass().getSimpleName().toLowerCase(Locale.ROOT), values, names);
        Stage stage = (Stage) hBox.getScene().getWindow();
        mController.tableController.refreshTable();
        stage.close();
    }


    public static void showAlert(String header, String message){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText(header);
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }

}

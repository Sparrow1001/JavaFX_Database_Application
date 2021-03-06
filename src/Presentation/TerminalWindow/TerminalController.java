package Presentation.TerminalWindow;

import Repository.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TerminalController {

    private DataBase database;
    @FXML
    private TextArea taTerminal;
    @FXML
    private TextField tfTerminal;

    @FXML
    public void initialize(){
        database = new DataBase();
        taTerminal.setText("mydb >>> Greetings, my lord!");
    }

    @FXML
    public void onEnterPressed(){
        if(!tfTerminal.getText().trim().isEmpty()) {
            String sql = tfTerminal.getText().trim();
            taTerminal.appendText("\nroot >>>" + tfTerminal.getText().trim());
            tfTerminal.setText("");
            String answer = database.handleStatement(sql);
            taTerminal.appendText("\nmydb >>>" + answer);
        }
    }
}

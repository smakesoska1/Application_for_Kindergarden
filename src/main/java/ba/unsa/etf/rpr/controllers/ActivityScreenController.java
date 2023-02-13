package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ActivityScreenController {
    @FXML
    private TextField textFieldActivity;
    @FXML
    private Button btnClose;


    public void addSave(){

    }

    public void close(ActionEvent event){
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();

    }
}

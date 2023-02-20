package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ActivityManager;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

/**
 * JavaFX controller for creating new activity
 *
 */

public class ActivityScreenController {
    @FXML
    private TextField textFieldActivity;
    @FXML
    private Button btnClose;
    @FXML
    private ListView activityList;


    /**
     * save button event handler (add activity)
     */
    public void addSave() throws KindergardenException {
        Activity activity=new Activity();
        ActivityManager manager=new ActivityManager();
        if(!textFieldActivity.getText().isEmpty()){
            activity.setActivityName(textFieldActivity.getText());
            manager.add(activity);
            Stage stage = (Stage) textFieldActivity.getScene().getWindow();
            stage.close();
        }
    }

    /**
     * cancel button event handler
     * @param event
     */

    public void close(ActionEvent event){
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

}

package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ParentManager;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * JavaFX controller for adding parent and setting up alert
 *
 */
public class AddParentScreenController {
    @FXML
    private TextField parentName;
    @FXML
    private TextField parentSurname;
    @FXML
    private TextField parentAdress;
    @FXML
    private TextField parentUsername;
    @FXML
    private TextField parentPassword;
    @FXML
    private TextField parentPhone;
    @FXML
    private Button btnCancel;

    public void cancel(){
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void addParent() throws KindergardenException {
        Parent parent=new Parent();
        ParentManager manager=new ParentManager();
        if(!parentName.getText().isEmpty() && !parentSurname.getText().isEmpty() && !parentAdress.getText().isEmpty()
        && !parentUsername.getText().isEmpty() && !parentPassword.getText().isEmpty() && !parentPhone.getText().isEmpty()){

            parent.setFirstName(parentName.getText());
            parent.setSurname(parentSurname.getText());
            parent.setAdress(parentAdress.getText());
            parent.setUsername(parentUsername.getText());
            parent.setPassword(parentPassword.getText());
            parent.setPhoneNumber(Integer.parseInt(parentPhone.getText()));

            manager.add(parent);


            Stage stage = (Stage) parentName.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add information");
            alert.setHeaderText("Results:");
            alert.setContentText("Some fields are empty. Please try again.");

            alert.showAndWait();
        }


    }
}

package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.DirectorManager;
import ba.unsa.etf.rpr.business.TeacherManager;
import ba.unsa.etf.rpr.dao.DirectorDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Director;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.domain.Person;
import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ba.unsa.etf.rpr.dao.DirectorDao;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class LoginController {
    public TextField usernameid;
    public Button cancelButtonId;
    public PasswordField passwordField;
    DirectorManager directorm=new DirectorManager();
    TeacherManager teacherm=new TeacherManager();

    public void actionLogin(ActionEvent actionEvent) throws KindergardenException {

        Person whoWantsToLogin = null;

        Director director = directorm.searchDirectorByUsername(usernameid.getText());
        if (director != null) {
            if (director.getPassword().equals(passwordField.getText())) {
                whoWantsToLogin = director;
            }else{
                showAlertWithHeaderText();
            }
        } else {
            Teacher teacher = teacherm.searchTeacherByUsername(usernameid.getText());
            if (teacher != null) {
                if (teacher.getPassword().equals(passwordField.getText())) {
                    whoWantsToLogin = teacher;
                }
            }
        }

        if (whoWantsToLogin instanceof Director) {
            openDirectorHomeScene();
            usernameid.getScene().getWindow().hide();
        } else if (whoWantsToLogin instanceof Teacher) {
           // openTeacherHomeScene((Teacher) whoWantsToLogin);
        } else {

        }
    }

    private void openDirectorHomeScene() {
        Stage stage = new Stage();
        javafx.scene.Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/directorScreen.fxml"));
            DirectorScreenController directorHomeController = new DirectorScreenController();
            loader.setController(directorHomeController);
            root = loader.load();
            stage.setTitle("Director's home");
            stage.setScene(new Scene(root,USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
            stage.toFront();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlertWithHeaderText() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login information");
        alert.setHeaderText("Results:");
        alert.setContentText("Incorrect password. Please try again.");

        alert.showAndWait();
    }

}

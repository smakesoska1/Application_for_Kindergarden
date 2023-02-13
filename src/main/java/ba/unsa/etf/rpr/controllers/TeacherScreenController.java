package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ActivityManager;
import ba.unsa.etf.rpr.business.ChildManager;
import ba.unsa.etf.rpr.business.ChildNotesManager;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;

public class TeacherScreenController {
    @FXML
    private ListView childrenList;
    @FXML
    private ListView activityList;
    @FXML
    private ListView notesList;
    @FXML
    private Button logOutBtn;


    private Teacher teacher;
    private ChildManager manager;
    private ActivityManager managera;
    private ChildNotesManager managercn;

    public TeacherScreenController(Teacher whoWantsToLogin) {
        this.teacher=whoWantsToLogin;
        manager=new ChildManager();
        managera=new ActivityManager();
        managercn=new ChildNotesManager();
    }

    @FXML
    public void initialize() throws KindergardenException {
        List<Child> children = manager.searchChildrenOfTeacher(teacher.getId());
        childrenList.setItems(FXCollections.observableArrayList(children));
        activityList.setItems(FXCollections.observableArrayList(managera.getAll()));
        notesList.setItems(FXCollections.observableArrayList(managercn.getAll()));

    }

    public void logOut(){
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
    }
}

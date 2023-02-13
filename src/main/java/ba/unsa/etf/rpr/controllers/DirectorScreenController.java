package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ActivityManager;
import ba.unsa.etf.rpr.business.ChildManager;
import ba.unsa.etf.rpr.business.ParentManager;
import ba.unsa.etf.rpr.business.TeacherManager;
import ba.unsa.etf.rpr.domain.*;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class DirectorScreenController {
    @FXML
    private Button logOutBtn;
    @FXML
    private ListView childrenList;
    @FXML
     private ListView teacherList;
    @FXML
     private ListView activitiList;
    @FXML
     private ListView parentList;
    @FXML
      private Button deleteParentBtn;
    @FXML
       private Button deleteActivityBtn;

    private Child selectedChild;
    private Teacher selectedTeacher;
    private Activity selectedActivity;
    private Parent selectedParent;
    private ChildNotes selectedNotes;


    ChildManager managerc=new ChildManager();
    TeacherManager managert=new TeacherManager();
    ActivityManager managera=new ActivityManager();
    ParentManager managerp=new ParentManager();

    public Child getSelectedChild() {
        return selectedChild;
    }

    public Teacher getSelectedTeacher() {
        return selectedTeacher;
    }

    public Activity getSelectedActivity() {
        return selectedActivity;
    }

    public Parent getSelectedParent() {
        return selectedParent;
    }

    public ChildNotes getSelectedNotes() {
        return selectedNotes;
    }

    public void logOut(){
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void initialize() throws KindergardenException {
        childrenList.setItems(FXCollections.observableArrayList(managerc.getAll()));
        teacherList.setItems(FXCollections.observableArrayList(managert.getAll()));
        activitiList.setItems(FXCollections.observableArrayList(managera.getAll()));
        parentList.setItems(FXCollections.observableArrayList(managerp.getAll()));
    }
}

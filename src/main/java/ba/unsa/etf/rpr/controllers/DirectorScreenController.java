package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ActivityManager;
import ba.unsa.etf.rpr.business.ChildManager;
import ba.unsa.etf.rpr.business.ParentManager;
import ba.unsa.etf.rpr.business.TeacherManager;
import ba.unsa.etf.rpr.domain.*;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

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
    @FXML
    private Button deleteChildBtn;
    @FXML
    private Button deleteTeacherBtn;

    private Child selectedChild;
    private Teacher selectedTeacher;
    private Parent selectedParent;
    private ChildNotes selectedNotes;
    private Activity selectedActivity;


    ChildManager managerc=new ChildManager();
    TeacherManager managert=new TeacherManager();
    ActivityManager managera=new ActivityManager();
    ParentManager managerp=new ParentManager();


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

        activitiList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedActivity = (Activity) newValue;
        });
        parentList.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue )->{
            selectedParent=(Parent) newValue;
        });

        teacherList.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue )->{
            selectedTeacher=(Teacher) newValue;
        });

        childrenList.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue )->{
            selectedChild=(Child) newValue;
        });
    }

    @FXML
    public void deleteActivity(ActionEvent event) throws KindergardenException {
            try {
                Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete");
                Optional<ButtonType> result = confirmation.showAndWait();
                if (!result.get().getButtonData().isCancelButton()) {
                    selectedActivity = (Activity) activitiList.getSelectionModel().getSelectedItem();
                    if (selectedActivity != null) {
                        managera.delete(selectedActivity.getId());
                        activitiList.getItems().remove(selectedActivity);
                    }
                }
            }catch (KindergardenException e) {
                new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
            }
    }

    @FXML
    public void deleteParent(ActionEvent event){
        try {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete parent?");
            Optional<ButtonType> result = confirmation.showAndWait();
            if (!result.get().getButtonData().isCancelButton()) {
                selectedParent = (Parent) parentList.getSelectionModel().getSelectedItem();
                if (selectedParent != null) {
                    managerp.delete(selectedParent.getId());
                    parentList.getItems().remove(selectedParent);
                }
            }
        }catch (KindergardenException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    @FXML
    public void deleteTeacher(ActionEvent event){
        try {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete teacher?");
            Optional<ButtonType> result = confirmation.showAndWait();
            if (!result.get().getButtonData().isCancelButton()) {
                selectedTeacher = (Teacher) teacherList.getSelectionModel().getSelectedItem();
                if (selectedTeacher != null) {
                    managert.delete(selectedTeacher.getId());
                    teacherList.getItems().remove(selectedTeacher);
                }
            }
        }catch (KindergardenException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    @FXML
    public void deleteChild(){
        try {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to child?");
            Optional<ButtonType> result = confirmation.showAndWait();
            if (!result.get().getButtonData().isCancelButton()) {
                selectedChild = (Child) childrenList.getSelectionModel().getSelectedItem();
                if (selectedChild != null) {
                    managerc.delete(selectedChild.getId());
                    childrenList.getItems().remove(selectedChild);
                }
            }
        }catch (KindergardenException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }

    }


    }


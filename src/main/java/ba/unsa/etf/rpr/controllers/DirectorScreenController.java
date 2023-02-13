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

import java.awt.event.ActionEvent;
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
    }

    @FXML
    public void deleteActivity( ) throws KindergardenException {
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
    public void deleteParent(){


    }
}

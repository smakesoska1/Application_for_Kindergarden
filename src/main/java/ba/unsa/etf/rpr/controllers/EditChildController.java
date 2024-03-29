package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ActivityManager;
import ba.unsa.etf.rpr.business.ChildManager;
import ba.unsa.etf.rpr.business.ChildNotesManager;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.domain.ChildNotes;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.List;

/**
 * JavaFX controller for editing childs info about activities and teacher's notes
 *
 */

public class EditChildController {
    private Child child;
    @FXML
    private Label childName;
    @FXML
    private Label childSurname;
    @FXML
    private Label childAdress;
    @FXML
    private Label childParentName;
    @FXML
    private Label childParentSurname;
    @FXML
    private Label startTime;
    @FXML
    private Label endTime;
    @FXML
    private ChoiceBox<Activity> activityCheck;
    @FXML
    private ChoiceBox<ChildNotes>notesCheck;
    @FXML
    private Button closeBtn;

    private ActivityManager managera=new ActivityManager();
    private ChildNotesManager managercn=new ChildNotesManager();
    private ChildManager managerc=new ChildManager();


    public void setChild(Child selectedChild) {
        this.child=selectedChild;
    }

   public void initialize() throws KindergardenException {
        childName.setText(child.getFirstName());
        childSurname.setText(child.getSurname());
        childAdress.setText(child.getAdress());
        childParentName.setText(child.getParent().getFirstName());
        childParentSurname.setText(child.getParent().getSurname());
        startTime.setText(child.getStartTime().toString());
        endTime.setText(child.getEndTime().toString());

        List<Activity> activities=managera.getAll();
        activityCheck.setItems(FXCollections.observableArrayList(activities));
        activityCheck.setValue(child.getActivity());

       List<ChildNotes> notes=managercn.getAll();
       notesCheck.setItems(FXCollections.observableArrayList(notes));
       notesCheck.setValue(child.getChildNotes());
   }

   public void close(){
       Stage stage = (Stage) closeBtn.getScene().getWindow();
       stage.close();

   }

   public void addChanges(){
        child.setActivity(activityCheck.getValue());
        child.setChildNotes(notesCheck.getValue());
       try {
           managerc.update(child);
           Stage stage = (Stage) activityCheck.getScene().getWindow();
           stage.close();
       } catch (KindergardenException e) {
           e.printStackTrace();
       }
   }
}

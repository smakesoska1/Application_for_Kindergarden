package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.Child;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewChildScreenController {
    private Child child;
    @FXML
    private Button closeBtn;
    @FXML
    private Label childName;
    @FXML
    private Label childSurname;
    @FXML
    private Label childAdress;
    @FXML
    private Label childEnd;
    @FXML
    private Label childStart;
    @FXML
    private Label childActivity;
    @FXML
    private Label childParent;
    @FXML
    private Label childPhone;
    @FXML
    private Label childTeacher;
    @FXML
    private Label childNote;


    public void setChild(Child selectedChild) {
        this.child=selectedChild;
    }

    public void initialize(){
        childName.setText(child.getFirstName());
        childSurname.setText(child.getSurname());
        childAdress.setText(child.getAdress());
        childParent.setText(child.getParent().toString());
        childStart.setText(child.getStartTime().toString());
        childTeacher.setText(child.getTeacher().toString());
        childActivity.setText(child.getActivity().getActivityName());
        childEnd.setText(child.getEndTime().toString());
        childNote.setText(child.getChildNotes().getNoteName());
        childPhone.setText(String.valueOf(child.getParent().getPhoneNumber()));
    }
    
    public void close(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}

package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ChildManager;
import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.util.List;


public class ParentScreenController {
    @FXML
    private Label childName1;
    @FXML
    private Label childSurname1;
    @FXML
    private Label childAdress1;
    @FXML
    private Label childTeacherName;
    @FXML
    private Label childTeacherSurname;
    @FXML
    private Label childActivity;
    @FXML
    private Label childNote;
    @FXML
    private Label childStart;
    @FXML
    private Label childEnd;
    @FXML
    private Label childName2;
    @FXML
    private Label childSurname2;
    @FXML
    private Label childAdress2;
    @FXML
    private Label childActivity2;
    @FXML
    private Label childNote2;
    @FXML
    private Label childStart1;
    @FXML
    private Label childEnd1;
    @FXML
    private Button logOutBtn;

    private Parent parent;
    private ChildManager manager;

    public ParentScreenController(Parent whoWantsToLogin) {
        this.parent = whoWantsToLogin;
        manager = new ChildManager();
    }

    @FXML
    public void initialize() throws KindergardenException {
        List<Child> children = manager.searchChildrenOfParent(parent.getId());

        if (children.size() > 0) {
            Child child1 = children.get(0);
            childName1.setText(child1.getFirstName());
            childSurname1.setText(child1.getSurname());
            childAdress1.setText(child1.getAdress());
            childTeacherName.setText(child1.getTeacher().getFirstName());
            childTeacherSurname.setText(child1.getTeacher().getSurname());
            childActivity.setText(child1.getActivity().getActivityName());
            childNote.setText(child1.getChildNotes().getNoteName());
            childStart.setText(child1.getStartTime().toString());
            childEnd.setText(child1.getEndTime().toString());

            if (children.size() > 1) {
                Child child2 = children.get(1);
                childName2.setText(child2.getFirstName());
                childSurname2.setText(child2.getSurname());
                childAdress2.setText(child2.getAdress());
                childTeacherName.setText(child2.getTeacher().getFirstName());
                childTeacherSurname.setText(child2.getTeacher().getSurname());
                childActivity2.setText(child2.getActivity().getActivityName());
                childNote2.setText(child2.getChildNotes().getNoteName());
                childStart1.setText(child2.getStartTime().toString());
                childEnd1.setText(child2.getEndTime().toString());

            }
        }
    }

    public void close(){
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
    }
}


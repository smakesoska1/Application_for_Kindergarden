package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.*;
import ba.unsa.etf.rpr.domain.*;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AddChildScreenController {
    @FXML
    private TextField childName;
    @FXML
    private TextField childSurname;
    @FXML
    private TextField childAdress;
    @FXML
    private ChoiceBox<Activity> activityChoice;
    @FXML
    private ChoiceBox<ChildNotes> notesChoice;
    @FXML
    private ChoiceBox<Parent> parentChoice;
    @FXML
    private ChoiceBox<Teacher> teacherChoice;
    @FXML
    private ChoiceBox startTime;
    @FXML
    private ChoiceBox endTime;
    @FXML
    private Button closeBtn;

    private Child child=new Child();

    private ActivityManager managera=new ActivityManager();
    private ParentManager managerp=new ParentManager();
    private TeacherManager managert=new TeacherManager();
    private ChildNotesManager managercn=new ChildNotesManager();
    private ChildManager managerc=new ChildManager();


    public void initialize() throws KindergardenException {
        List<Activity> activities=managera.getAll();
        List<Teacher> teachers=managert.getAll();
        List<Parent> parents=managerp.getAll();
        List<ChildNotes> notes=managercn.getAll();
        List<LocalTime> time=new ArrayList<>();

        activityChoice.setItems(FXCollections.observableArrayList(activities));
        activityChoice.setValue(child.getActivity());

        notesChoice.setItems(FXCollections.observableArrayList(notes));
        notesChoice.setValue(child.getChildNotes());

        parentChoice.setItems(FXCollections.observableArrayList(parents));
        parentChoice.setValue(child.getParent());

        teacherChoice.setItems(FXCollections.observableArrayList(teachers));
        teacherChoice.setValue(child.getTeacher());

        time.add(LocalTime.parse("08:00"));
        time.add(LocalTime.parse("09:00"));
        time.add(LocalTime.parse("10:00"));
        time.add(LocalTime.parse("11:00"));
        time.add(LocalTime.parse("12:00"));
        time.add(LocalTime.parse("13:00"));
        time.add(LocalTime.parse("14:00"));
        time.add(LocalTime.parse("15:00"));
        time.add(LocalTime.parse("16:00"));
        time.add(LocalTime.parse("17:00"));
        time.add(LocalTime.parse("18:00"));
        time.add(LocalTime.parse("19:00"));
        time.add(LocalTime.parse("20:00"));

        startTime.setItems(FXCollections.observableArrayList(time));
        endTime.setItems(FXCollections.observableArrayList(time));
    }

    public void addChild() throws KindergardenException {
        child.setFirstName(childName.getText());
        child.setSurname(childSurname.getText());
        child.setAdress(childAdress.getText());
        child.setParent(parentChoice.getSelectionModel().getSelectedItem());
        child.setTeacher(teacherChoice.getSelectionModel().getSelectedItem());
        child.setActivity(activityChoice.getSelectionModel().getSelectedItem());
        child.setChildNotes(notesChoice.getSelectionModel().getSelectedItem());
        child.setStartTime((LocalTime) startTime.getSelectionModel().getSelectedItem());
        child.setEndTime((LocalTime) endTime.getSelectionModel().getSelectedItem());

        managerc.add(child);
        Stage stage = (Stage) childName.getScene().getWindow();
        stage.close();
    }

    public void close(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();

    }
}

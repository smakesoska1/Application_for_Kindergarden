package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ActivityManager;
import ba.unsa.etf.rpr.business.ChildManager;
import ba.unsa.etf.rpr.business.ChildNotesManager;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.domain.ChildNotes;
import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class TeacherScreenController {
    @FXML
    private ListView childrenList;
    @FXML
    private ListView activityList;
    @FXML
    private ListView notesList;
    @FXML
    private Button logOutBtn;
    @FXML
    private Button removeNote;


    private Teacher teacher;
    private ChildManager manager;
    private ActivityManager managera;
    private ChildNotesManager managercn;

    private Child selectedChild;
    private Activity selectedActivity;
    private ChildNotes selectedNote;


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

        notesList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedNote = (ChildNotes) newValue;
        });

    }

    public void logOut(){
        Stage stage = (Stage) logOutBtn.getScene().getWindow();
        stage.close();
    }

    public void removeNote(){
        try {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete note?");
            Optional<ButtonType> result = confirmation.showAndWait();
            if (!result.get().getButtonData().isCancelButton()) {
                selectedNote = (ChildNotes) notesList.getSelectionModel().getSelectedItem();
                if (selectedNote != null) {
                    managercn.delete(selectedNote.getId());
                    notesList.getItems().remove(selectedNote);
                }
            }
        }catch (KindergardenException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }

    }

    public void addActivity(){
        Stage stage = new Stage();
        javafx.scene.Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addActivity.fxml"));
            ActivityScreenController activityHomeController = new ActivityScreenController();
            loader.setController(activityHomeController);
            root = loader.load();
            stage.setTitle("Add activity");
            stage.setScene(new Scene(root,USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
            stage.toFront();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNote(){
        Stage stage = new Stage();
        javafx.scene.Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addNote.fxml"));
            NoteScreenController noteHomeController = new NoteScreenController();
            loader.setController(noteHomeController);
            root = loader.load();
            stage.setTitle("Add note description");
            stage.setScene(new Scene(root,USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
            stage.toFront();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

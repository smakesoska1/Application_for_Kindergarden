package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ActivityManager;
import ba.unsa.etf.rpr.business.ChildNotesManager;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.domain.ChildNotes;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NoteScreenController {
    @FXML
    private TextField textFieldNote;
    @FXML
    private Button closeBtn;

    public void addNote() throws KindergardenException {
        ChildNotes notes =new ChildNotes();
        ChildNotesManager manager=new ChildNotesManager();
        if(!textFieldNote.getText().isEmpty()){
            notes.setNoteName(textFieldNote.getText());
            manager.add(notes);
            Stage stage = (Stage) textFieldNote.getScene().getWindow();
            stage.close();
        }
    }

    public void close(ActionEvent event){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}

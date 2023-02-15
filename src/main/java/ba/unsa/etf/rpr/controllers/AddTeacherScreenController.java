package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.TeacherManager;
import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalTime;


public class AddTeacherScreenController {
    @FXML
    private TextField teacherName;
    @FXML
    private TextField teacherSurname;
    @FXML
    private TextField teacherAdress;
    @FXML
    private TextField teacherUsername;
    @FXML
    private TextField teacherPassword;
    @FXML
    private RadioButton eightRadio,nineRadio,tenRadio,sixteenRadio,eightteenRadio,seventeenRadio;
    @FXML
    private Button closeBtn;
    private LocalTime times;
    private LocalTime timeend;

    public void addTeacher() throws KindergardenException {
        Teacher teacher=new Teacher();
        TeacherManager manager=new TeacherManager();


        if(!teacherName.getText().isEmpty() && !teacherSurname.getText().isEmpty() && !teacherAdress.getText().isEmpty()
                && !teacherUsername.getText().isEmpty() && !teacherPassword.getText().isEmpty()){

            teacher.setFirstName(teacherName.getText());
            teacher.setSurname(teacherSurname.getText());
            teacher.setAdress(teacherAdress.getText());
            teacher.setUsername(teacherUsername.getText());
            teacher.setPassword(teacherPassword.getText());

            if(eightRadio.isSelected()){
                times=LocalTime.of(8,0);
            }else if(nineRadio.isSelected()){
                times=LocalTime.of(9,0);
            }else if(tenRadio.isSelected()){
                times= LocalTime.of(10,0);
            }

            teacher.setStartWork(times);

            if(sixteenRadio.isSelected()){
                timeend=LocalTime.of(16,0);
            }else if(seventeenRadio.isSelected()){
                timeend=LocalTime.of(17,0);
            }else if(eightteenRadio.isSelected()){
                timeend= LocalTime.of(18,0);
            }

            teacher.setEndWork(timeend);

            manager.add(teacher);

            Stage stage = (Stage) teacherName.getScene().getWindow();
            stage.close();
        }
    }

    public void close(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}

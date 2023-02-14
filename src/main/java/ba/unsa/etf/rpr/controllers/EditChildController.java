package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.Child;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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


    public void setChild(Child selectedChild) {
        this.child=selectedChild;
    }

   public void initialize(){
        childName.setText(child.getFirstName());
        childSurname.setText(child.getSurname());
        childAdress.setText(child.getAdress());
        childParentName.setText(child.getParent().getFirstName());
        childParentSurname.setText(child.getParent().getSurname());
        startTime.setText(child.getStartTime().toString());
        endTime.setText(child.getEndTime().toString());
   }

   public void close(){

   }

   public void addChanges(){

   }



}

package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ChildManager;
import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;


public class ParentScreenController {
    @FXML
    private Label childName1;
    @FXML
    private Label childSurname1;
    private Parent parent;
    private ChildManager manager;

    public ParentScreenController(Parent whoWantsToLogin) {
        this.parent = whoWantsToLogin;
        manager = new ChildManager();
    }

    @FXML
    public void initialize() throws KindergardenException {
        List<Child> children = manager.searchChildrenOfParent(parent.getId());
        Child child1 = children.get(0);
        childName1.setText(child1.getFirstName());
        childSurname1.setText(child1.getSurname());



    }
}


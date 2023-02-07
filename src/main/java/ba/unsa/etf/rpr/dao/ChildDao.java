package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.ArrayList;

public interface ChildDao extends Dao<Child> {

    public ArrayList<Child> searchChildrenOfParent(int parentid) throws KindergardenException;

    public ArrayList<Child> searchChildrenOfTeacher(int teacherid) throws KindergardenException;
}

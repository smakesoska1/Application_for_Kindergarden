package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Child;

import java.util.ArrayList;

public interface ChildDao extends Dao<Child> {

    public ArrayList<Child> searchChildrenOfParent(int parentid);

    public ArrayList<Child> searchChildrenOfTeacher(int teacherid);
}

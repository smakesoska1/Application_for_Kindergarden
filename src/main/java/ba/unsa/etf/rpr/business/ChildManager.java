package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.ArrayList;
import java.util.List;

public class ChildManager {

    public List<Child> getAll() throws KindergardenException {
        return DaoFactory.childDao().getAll();
    }

    public void delete(int id) throws KindergardenException{
        DaoFactory.childDao().delete(id);
    }

    public Child getById(int childId) throws KindergardenException{
        return DaoFactory.childDao().getById(childId);
    }

    public void update(Child cn) throws KindergardenException{
        DaoFactory.childDao().update(cn);
    }

    public Child add(Child cn) throws KindergardenException{
        return DaoFactory.childDao().add(cn);
    }

    public ArrayList<Child> searchChildrenOfParent(int parentId) throws KindergardenException{
        return DaoFactory.childDao().searchChildrenOfParent(parentId);
    }

    public ArrayList<Child> searchChildrenOfTeacher(int teacherId) throws KindergardenException{
        return DaoFactory.childDao().searchChildrenOfTeacher(teacherId);
    }
}

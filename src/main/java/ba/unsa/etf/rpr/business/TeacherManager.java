package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.List;

public class TeacherManager {

    public void validateUsername(String username) throws KindergardenException {
        if (username == null || username.length() > 45 || username.length() < 2){
            throw new KindergardenException("Username must be between 2 and 45 chars");
        }
    }

    public List<Parent> getAll() throws KindergardenException {
        return DaoFactory.parentDao().getAll();
    }

    public void delete(int id) throws KindergardenException{
        DaoFactory.parentDao().delete(id);
    }

    public Parent getById(int parentId) throws KindergardenException{
        return DaoFactory.parentDao().getById(parentId);
    }

    public void update(Parent p) throws KindergardenException{
        validateUsername(p.getUsername());
        DaoFactory.parentDao().update(p);
    }

    public Parent add(Parent p) throws KindergardenException{
        validateUsername(p.getUsername());
        return DaoFactory.parentDao().add(p);
    }
}

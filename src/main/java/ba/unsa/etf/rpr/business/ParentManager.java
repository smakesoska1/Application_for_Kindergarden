package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.ChildNotes;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.List;

public class ParentManager {

    public void validateUsername(String username) throws KindergardenException {
        if (username == null || username.length() > 45 || username.length() < 4){
            throw new KindergardenException("Username must be between 4 and 45 chars");
        }
    }

    public static boolean validateUser(String correctName, String correctPass) {
        try {
            Parent parent= DaoFactory.parentDao().searchParentByUsername(correctName);
            if(parent.getPassword().equals(correctPass))
                return true;
        } catch (KindergardenException e) {
            System.out.println("Nepostojeci username i password");
            return false;
        }
        return true;
    }

    public List<Parent> getAll() throws KindergardenException {
        return DaoFactory.parentDao().getAll();
    }

    public void delete(int id) throws KindergardenException{
        try{
            DaoFactory.parentDao().delete(id);
        }catch (KindergardenException e){
            if (e.getMessage().contains("FOREIGN KEY")){
                throw new KindergardenException("Cannot delete parent which is related to child. First delete related child before deleting parent.");
            }
            throw e;
        }
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
    public Parent searchParentByUsername(String username) throws KindergardenException{
        return DaoFactory.parentDao().searchParentByUsername(username);
    }
}

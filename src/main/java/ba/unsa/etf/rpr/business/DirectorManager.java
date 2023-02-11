package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Director;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

public class DirectorManager {

    public void validateUsername(String username) throws KindergardenException {
        if (username == null || username.length() > 45 || username.length() < 4){
            throw new KindergardenException("Username must be between 4 and 45 chars");
        }
    }

    public static boolean validateDirector(String correctName, String correctPass) {
        try {
            Director director= DaoFactory.directorDao().searchDirectorByUsername(correctName);
            if(director.getPassword().equals(correctPass))
                return true;
        } catch (KindergardenException e) {
            System.out.println("Nepostojeci username i password");
            return false;
        }
        return true;
    }

    public Director update(Director d) throws KindergardenException{
        validateUsername(d.getUsername());
        return DaoFactory.directorDao().update(d);
    }

    public Director searchDirectorByUsername(String username) throws KindergardenException {
        validateUsername(username);
        return DaoFactory.directorDao().searchDirectorByUsername(username);
    }

}

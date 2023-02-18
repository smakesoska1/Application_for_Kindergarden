package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.ArrayList;

/**
 * Dao interface for Child domain bean
 */

public interface ChildDao extends Dao<Child> {

    /**
     * Returns all children from specific parent.
     *
     * @param parentid id from specific parent
     * @return list of children
     */
    public ArrayList<Child> searchChildrenOfParent(int parentid) throws KindergardenException;

    /**
     * Returns all children from specific teacher.
     *
     * @param teacherid id from specific teacher
     * @return list of children
     */
    public ArrayList<Child> searchChildrenOfTeacher(int teacherid) throws KindergardenException;
}

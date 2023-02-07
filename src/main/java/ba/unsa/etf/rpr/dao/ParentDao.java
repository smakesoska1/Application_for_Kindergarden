package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

public interface ParentDao extends Dao<Parent> {
    Parent searchParentByUsername(String username) throws KindergardenException;
}

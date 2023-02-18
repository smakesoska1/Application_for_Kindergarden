package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

/**
 * Dao interface for Parent domain bean
 */

public interface ParentDao extends Dao<Parent> {
    /**
     * Returns parent that is found based on username.
     *
     * @param -username
     * @return parent
     */
    Parent searchParentByUsername(String username) throws KindergardenException;
}

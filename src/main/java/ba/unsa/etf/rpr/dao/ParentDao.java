package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Parent;

public interface ParentDao extends Dao<Parent> {
    Parent searchParentByUsername(String username);
}

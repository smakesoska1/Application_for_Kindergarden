package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.domain.ChildNotes;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.List;

/**
 * Business Logic Layer for management of Notes
 */

public class ChildNotesManager {

        public List<ChildNotes> getAll() throws KindergardenException {
            return DaoFactory.childNotesDao().getAll();
        }

        public void delete(int id) throws KindergardenException{
            try{
                DaoFactory.childNotesDao().delete(id);
            }catch (KindergardenException e) {
                if (e.getMessage().contains("FOREIGN KEY")) {
                    throw new KindergardenException("Cannot delete note which is related to child. First delete/update related child before deleting note.");
                }
                throw e;
            }
        }

        public ChildNotes getById(int childNotesId) throws KindergardenException{
            return DaoFactory.childNotesDao().getById(childNotesId);
        }

        public void update(ChildNotes cn) throws KindergardenException{
            DaoFactory.childNotesDao().update(cn);
        }

        public ChildNotes add(ChildNotes cn) throws KindergardenException{
            return DaoFactory.childNotesDao().add(cn);
        }
    }


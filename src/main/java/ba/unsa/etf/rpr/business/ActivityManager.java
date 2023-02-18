package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.List;
/*
*manager class for activity
 */
public class ActivityManager {
    public List<Activity> getAll() throws KindergardenException{
        return DaoFactory.activityDao().getAll();
    }

    public void delete(int id) throws KindergardenException{
        try{
            DaoFactory.activityDao().delete(id);
        }catch (KindergardenException e){
            if (e.getMessage().contains("FOREIGN KEY")){
                throw new KindergardenException("Cannot delete activity which is related to child. First delete/update related child before deleting activity.");
            }
            throw e;
        }

    }

    public Activity getById(int activityId) throws KindergardenException{
        return DaoFactory.activityDao().getById(activityId);
    }

    public void update(Activity a) throws KindergardenException{
        DaoFactory.activityDao().update(a);
    }

    public Activity add(Activity a) throws KindergardenException{
        return DaoFactory.activityDao().add(a);
    }

}

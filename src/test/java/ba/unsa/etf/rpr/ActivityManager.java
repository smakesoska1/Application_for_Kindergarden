package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.ActivityDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityManager {
    @Test
    public void testUpdateActivity() throws KindergardenException {
        ActivityDaoSQLImpl activityDao=new ActivityDaoSQLImpl();
        Activity originalActivity = activityDao.getById(1);
        String orginal=originalActivity.getActivityName();

        Activity updatedActivity = new Activity();
        updatedActivity.setId(1);
        updatedActivity.setActivityName("Igranje");
        String updateAc=updatedActivity.getActivityName();

        activityDao.update(updatedActivity);
        Activity retrievedActivity = activityDao.getById(1);
        String newName=retrievedActivity.getActivityName();

        assertNotNull(originalActivity);
        assertNotNull(retrievedActivity);
        //assertNotEquals(orginal,newName);
        assertEquals(newName, updateAc);
    }
}

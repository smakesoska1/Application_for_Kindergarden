package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.ActivityDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ActivityTest {

    @Test
    public void testUpdateActivity() throws KindergardenException {
        ActivityDaoSQLImpl activityDao=new ActivityDaoSQLImpl();
        Activity originalActivity = activityDao.getById(1);

        Activity updatedActivity = new Activity();
        updatedActivity.setId(1);
        updatedActivity.setActivityName("Igranje");
        String updateAc=updatedActivity.getActivityName();

        activityDao.update(updatedActivity);
        Activity retrievedActivity = activityDao.getById(1);
        String newName=retrievedActivity.getActivityName();

        assertNotNull(originalActivity);
        assertNotNull(retrievedActivity);
        assertEquals(newName, updateAc);
    }


}

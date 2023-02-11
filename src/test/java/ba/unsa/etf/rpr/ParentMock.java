package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ParentManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.ParentDao;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.domain.Person;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParentMock {

    @Test
    public void validateIfParentExist() throws KindergardenException {
            MockedStatic<DaoFactory> dao= Mockito.mockStatic(DaoFactory.class);
            ParentDao parentDao=Mockito.mock(ParentDao.class);
            Mockito.when(DaoFactory.parentDao()).thenReturn(parentDao);

        Parent parent = new Parent();
        parent.setUsername("ahalic");
        parent.setPassword("ahalic");

        Mockito.when(DaoFactory.parentDao().searchParentByUsername("ahalic")).thenReturn(parent);
        Parent returnedParent = DaoFactory.parentDao().searchParentByUsername("ahalic");
        boolean value = ParentManager.validateUser(returnedParent.getUsername(), returnedParent.getPassword());

        assertTrue(value);
        dao.close();
    }
}

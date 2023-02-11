package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ParentManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.ParentDao;
import ba.unsa.etf.rpr.dao.ParentDaoSQLImpl;
import ba.unsa.etf.rpr.dao.PersonDao;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.domain.Person;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParentMock {
    private ParentDaoSQLImpl parentDao;
    private ParentManager parentManager;
    List<Parent> parents;

    @BeforeEach
    public void initialize(){
        parentDao = Mockito.mock(ParentDaoSQLImpl.class);
        parentManager = Mockito.mock(ParentManager.class);
        parents=new ArrayList<>();

        Parent parent = new Parent();
        parent.setId(5);
        parent.setFirstName("Adnan");
        parent.setSurname("Hodzic");
        parent.setAdress("Maglajska");
        parent.setUsername("ahodzic2");
        parent.setPassword("ahodzic2");
        parent.setPhoneNumber(378645896);

        parents.add(parent);
    }


    @Test
    public void validateIfParentExist() throws KindergardenException {
            MockedStatic<DaoFactory> dao= Mockito.mockStatic(DaoFactory.class);
            parentDao=Mockito.mock(ParentDaoSQLImpl.class);
            Mockito.when(DaoFactory.parentDao()).thenReturn(parentDao);

        Parent parent = new Parent();
        parent.setUsername("ahalic");
        parent.setPassword("ahalic");

        Mockito.when(DaoFactory.parentDao().searchParentByUsername("ahalic")).thenReturn(parent);
        Parent returnedParent = DaoFactory.parentDao().searchParentByUsername("ahalic");
        boolean value = ParentManager.validateParent(returnedParent.getUsername(), returnedParent.getPassword());

        assertTrue(value);
        dao.close();
    }

    @Test
    public void addParent() throws KindergardenException {
        Parent parent = new Parent();
        parent.setId(5);
        parent.setFirstName("Lejla");
        parent.setSurname("Begic");
        parent.setAdress("Hiseta");
        parent.setUsername("lbegic1");
        parent.setPassword("lbegic1");
        parent.setPhoneNumber(378645896);

        parentManager.add(parent);
        Mockito.verify(parentManager).add(parent);

    }
}

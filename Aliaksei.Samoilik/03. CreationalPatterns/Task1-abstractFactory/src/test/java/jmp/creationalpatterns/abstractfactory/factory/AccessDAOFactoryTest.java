package jmp.creationalpatterns.abstractfactory.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import jmp.creationalpatterns.abstractfactory.dao.AccessPersonDAO;
import jmp.creationalpatterns.abstractfactory.dao.PersonDAO;

public class AccessDAOFactoryTest {
    private static final String FILE_NAME = "db error";
    @Test
    public void testReadPerson() {
      AccessDAOFactory AccessDAOFactory = new AccessDAOFactory();
      PersonDAO personalDao = AccessDAOFactory.getPersonDAO(FILE_NAME);

      assertTrue(personalDao.getClass().equals(AccessPersonDAO.class));
    }
}

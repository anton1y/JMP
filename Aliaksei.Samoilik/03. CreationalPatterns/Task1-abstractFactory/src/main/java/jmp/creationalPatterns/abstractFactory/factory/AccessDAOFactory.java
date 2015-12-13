package jmp.creationalPatterns.abstractFactory.factory;

import jmp.creationalPatterns.abstractFactory.dao.AccessPersonDAO;
import jmp.creationalPatterns.abstractFactory.dao.PersonDAO;

public class AccessDAOFactory extends AbstractDAOFactory {

    @Override
    public PersonDAO getPersonDAO(String fileName) {
        PersonDAO personDAO = new AccessPersonDAO(fileName);
        return personDAO;
    }

}

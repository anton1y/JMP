package jmp.creationalPatterns.abstractFactory.factory;

import jmp.creationalPatterns.abstractFactory.dao.FilePersonDAO;
import jmp.creationalPatterns.abstractFactory.dao.PersonDAO;

public class FileDAOFactory extends AbstractDAOFactory {

    @Override
    public PersonDAO getPersonDAO(String fileName) {
        PersonDAO personDAO = new FilePersonDAO(fileName);
        return personDAO;
    }

}

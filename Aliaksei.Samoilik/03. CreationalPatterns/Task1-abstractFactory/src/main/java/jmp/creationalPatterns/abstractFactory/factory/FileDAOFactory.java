package jmp.creationalpatterns.abstractfactory.factory;

import jmp.creationalpatterns.abstractfactory.dao.FilePersonDAO;
import jmp.creationalpatterns.abstractfactory.dao.PersonDAO;

public class FileDAOFactory extends AbstractDAOFactory {

    @Override
    public PersonDAO getPersonDAO(String fileName) {
        return new FilePersonDAO(fileName);
    }

}

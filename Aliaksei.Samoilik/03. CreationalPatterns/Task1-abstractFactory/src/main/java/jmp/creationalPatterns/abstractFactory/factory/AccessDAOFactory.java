package jmp.creationalpatterns.abstractfactory.factory;

import jmp.creationalpatterns.abstractfactory.dao.AccessPersonDAO;
import jmp.creationalpatterns.abstractfactory.dao.PersonDAO;

public class AccessDAOFactory extends AbstractDAOFactory {

    @Override
    public PersonDAO getPersonDAO(String fileName) {
        return new AccessPersonDAO(fileName);
    }

}

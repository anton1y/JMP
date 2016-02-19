package jmp.creationalpatterns.abstractfactory.factory;

import jmp.creationalpatterns.abstractfactory.dao.PersonDAO;

public abstract class AbstractDAOFactory {
    public static final String ACCESS = "access";
    public static final String FILE = "file";

    public abstract PersonDAO getPersonDAO(String fileName);
    // others DAO

    public static AbstractDAOFactory getDAOFactory(String whichFactory) {

        switch (whichFactory) {
        case ACCESS:
            return new AccessDAOFactory();
        case FILE:
            return new FileDAOFactory();
        default:
            return null;
        }
    }
}

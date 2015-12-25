package com.epam.training.module4.models;


import java.util.List;

import com.epam.training.module4.utils.PersonUtils;




public class FacadeForDBConnection {

    private H2Dao h2Dao;
    private PersonUtils personUtils;
    public FacadeForDBConnection(){
        h2Dao = new H2Dao();
        personUtils = new PersonUtils();
    }

    public void writePerson() {
        String name = personUtils.readName();
        Person person = new Person();
        person.setName(name);
        h2Dao.writePerson(person);
    }
    
    public void readPersons() {
        List<Person> lists = h2Dao.readPersons();
        personUtils.showPersons(lists);
    }
   
}

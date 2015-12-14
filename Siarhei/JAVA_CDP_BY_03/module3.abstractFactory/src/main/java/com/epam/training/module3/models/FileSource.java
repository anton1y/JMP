package com.epam.training.module3.models;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.epam.training.module3.sourceInterface.Source;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

public class FileSource implements Source {
    
    private ColumnPositionMappingStrategy<Person> columnStrategy;
    private CsvToBean<Person> csvToBean;
    public FileSource(){
        columnStrategy = new ColumnPositionMappingStrategy<Person>();
        columnStrategy.setType(Person.class);
        String[] columns = new String[] {"id", "name"}; 
        columnStrategy.setColumnMapping(columns);
        csvToBean = new CsvToBean<Person>();
    }
    public void writePerson(Person person) {
        CSVWriter writer = null;
        List<Person> persons = readPersons();
        try {
            writer = new CSVWriter(new FileWriter(readFile(), true));
            writer.writeNext(new String[] {String.valueOf(persons.get(persons.size()-1).getId()+1),person.getName()});
        } catch (IOException e) {
            System.err.println("problem with writting in file");
        } finally {
            closeConnection(writer);
        }

    }

    public List<Person> readPersons() {
        CSVReader csvReader = null;
        List<Person> list = null;
        try {
            csvReader = new CSVReader(new FileReader(readFile()));
            list = csvToBean.parse(columnStrategy, csvReader);
        } catch (FileNotFoundException e) {
            System.err.println("csv file not found");
            e.printStackTrace();
        } finally {
            closeConnection(csvReader);
        }

        return list;
    }

    public Person readPerson(String name) {
       List<Person> list = readPersons();
       for (Person person : list) {
           if (person.getName().equals(name)) {
            return person;
           }
       }
        return null;
    }
    
    private void closeConnection(Closeable reader){
        try {
            if (reader!=null) {
                reader.close();
            }
        } catch (IOException e) {
            System.err.println("problem with closing stream");
        }
    }
    
    private File readFile(){

        if (ClassLoader.getSystemResource("Persons.csv").getPath().contains(".jar")) {
            return  new File(new File("").getAbsolutePath()+"/classes/Persons.csv");
        } else {
            return  new File(ClassLoader.getSystemResource("Persons.csv").getFile());
        }

    }
}

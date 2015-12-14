package com.epam.training.module3.simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.epam.training.module3.factoryInterface.AbstractSourceFactory;
import com.epam.training.module3.models.DBSourceFactory;
import com.epam.training.module3.models.FileSourceFactory;
import com.epam.training.module3.models.Person;
import com.epam.training.module3.sourceInterface.Source;


public class AbstractFactorySimulator {
    public static void main(String[] args) {
        Source source = readTypeOfSource();
        int i = 0;
        while(true) {
            i = readCurrrentAction();
            if (i!=4) {
                doCurrentAvtion(source, i);
            } else {
                return;
            }
        }
    }

    private static void doCurrentAvtion(Source source, int i) {
        if (i==1) {
            List<Person> persons = source.readPersons();
            for (Person person : persons) {
                System.out.println("Person:"+person);
            }
        } else if (i==2) {
            String name = readName();
            Person person = source.readPerson(name);
            if (person!=null) {
                System.out.println("Person:"+person);
            } else {
                System.out.println("This person doesn't exist");
            }
        } else if (i==3) {
            String name = readName();
            Person person = new Person();
            person.setName(name);
            source.writePerson(person);
        }
    }

    private static String readName() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter username ");
        try {
            return br.readLine();
        } catch (IOException e) {
            System.err.println("Problem with reading data from console");
        }
        return null;
    }

    private static Source getSourceFromFactory(AbstractSourceFactory factory){
        return factory.createSource();
    }
    
    private static Source readTypeOfSource(){
        int i = 0;
        Source source = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("1 if you want work with csv file, 2 if you want work with db");
        try {
            i = Integer.parseInt(br.readLine());
        } catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        } catch (IOException e) {
            System.err.println("Problem with reading data from console");
        }
        if (i == 1) {
            source = getSourceFromFactory(new FileSourceFactory());
        } else if (i == 2) {
            source = getSourceFromFactory(new DBSourceFactory());
        }
        return source;
    }
   private static int readCurrrentAction() {
       int i = 0;
       while (true) {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           System.out.print("Please check operation: 1- read all person ; 2- find person by name; 3- write person; 4-exit");
           try {
               i = Integer.parseInt(br.readLine());
           } catch(NumberFormatException nfe){
               System.err.println("Invalid Format!");
           } catch (IOException e) {
               System.err.println("Problem with reading data from console");
           }
           if (i>0 && i<5) {
               return i;
           } else {
               System.out.println("Invalid exction");
           }
       }
   }
    
}

package com.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Driver {

    public static void main(String[] args) {
        List<Person> people = jackson();
        toString(people);
    }

    private static void toString(List<Person> people){
        for (Person person : people){
            person.printDetails();
        }
    }

    private static List<Person> jackson(){
        List<Person> people = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            Person person1 = mapper.readValue(new File("app\\src\\main\\resources\\input1.json"), Person.class);
            Person person2 = mapper.readValue(new File("app\\src\\main\\resources\\input2.json"), Person.class);
            Person person3 = mapper.readValue(new File("app\\src\\main\\resources\\input3.json"), Person.class);
            people.add(person1);
            people.add(person2);
            people.add(person3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return people;
    }
    
}


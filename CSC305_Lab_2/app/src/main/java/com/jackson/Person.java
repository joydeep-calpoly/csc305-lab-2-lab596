package com.jackson;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Person {
    
    private String name;
    private String[] knownFor;
    
    private static class Award{
        private int year;
        private String title;

        @JsonCreator
        private Award(@JsonProperty("year") int year, @JsonProperty("name") String title){
            this.year = year;
            this.title = title;
        }
    }
    private ArrayList<Award> awards; 

    @JsonCreator
    private Person(@JsonProperty("name") String name, @JsonProperty("knownFor") String[] knownFor, @JsonProperty("awards") List<Award> awards) {
        this.name = name;
        this.knownFor = knownFor;
        this.awards = (ArrayList<Award>) awards;
    }

    public void printDetails(){
        System.out.println(name);
            System.out.println();
            System.out.println("Known For:");
            for(String thing: knownFor){
                System.out.println(thing);
            }
            System.out.println();
            System.out.println("Awards:");
            for (Award award : awards){
                System.out.println(award.title + ", " + award.year);
            }
            System.out.println();
    }
}


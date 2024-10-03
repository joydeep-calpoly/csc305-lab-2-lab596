package com.json;

import java.util.List;
import java.util.ArrayList;

class Person {
    
    private String name;
    private String[] knownFor;

    public static class Award{
        private int year;
        private String title;

        public Award(int year, String title){
            this.year = year;
            this.title = title;
        }
    }

    private ArrayList<Award> awards; 

    public Person(String name, String[] knownFor, List<Award> awards){
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

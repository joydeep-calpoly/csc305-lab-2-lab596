package com.json;


import java.util.List;
import java.util.ArrayList;
import java.io.*; 


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.json.Person.Award;


public class Driver {
    public static void main(String[] args) {
        List<Person> peoples = json();
        toString(peoples);
    }

    private static void toString(List<Person> people){
        for (Person person : people){
            person.printDetails();
        }
    }

    private static List<Person> json(){
        List<File> files = new ArrayList<>();
        files.add(new File("app\\src\\main\\resources\\input1.json"));
        files.add(new File("app\\src\\main\\resources\\input2.json"));
        files.add(new File("app\\src\\main\\resources\\input3.json"));
        

        List<Person> people = new ArrayList<>();

        for (File file : files){
            InputStream is;
            try {
                is = new FileInputStream(file);
                JSONTokener tokener = new JSONTokener(is);
                JSONObject root = new JSONObject(tokener);
                //fetch all fields from json
                String name = root.getString("name");
                JSONArray knownFor = root.getJSONArray("knownFor");
                JSONArray awards = root.getJSONArray("awards");
                //convert fields and add to person object
                ArrayList<Award> awards2 = jsonArraytoArrayList(awards);
                String[] stringArray = jsonArraytoArray(knownFor);
                people.add(new Person(name, stringArray, awards2));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return people;
    }

    private static String[] jsonArraytoArray(JSONArray knownFor){
        String[] stringArray = new String[knownFor.length()];
        for (int j = 0; j < knownFor.length(); j++) {
            stringArray[j] = knownFor.getString(j);
        }
        return stringArray;
    }

    private static ArrayList<Award> jsonArraytoArrayList(JSONArray awards){
        ArrayList<Award> awards2 = new ArrayList<>();
        for (Object award: awards){
            JSONObject awarded = (JSONObject) award;
            awards2.add(new Award(awarded.getInt("year"), awarded.getString("name")));
        }
        return awards2;
    }
}

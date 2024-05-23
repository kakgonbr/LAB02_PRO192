package task02.lab02;

import java.util.ArrayList;
import misc.Utils;

public final class Person {
    // --------------------------------------------------------- Fields ------------------------------------------------------
    private int id; // ID can be negative
    private String name;
    private boolean gender;
    private static int personCount = 0;
    private static ArrayList<Integer> occupiedID = new ArrayList<>();
    // ---------------------------------------------------- Constructor ------------------------------------------------------
    public Person(int _id, String _name, boolean _gender){
        while(!setID(_id++));
        setName(_name);
        setGender(_gender);

        personCount++;
    }
    public Person(int _id, String _name, String _gender){
        while(!setID(_id++));
        setName(_name);
        if (!setGender(_gender)) {
            System.out.println("Warning: invalid gender for constructor, setting \"male\" as gender.");
            setGender(true);
        }

        personCount++;
    }
    // Default constructor
    public Person(){
        int temp = personCount;
        while (!setID(temp++));
        setName("Person " + personCount); // Name doesn't have to be unique, but in the case of using a default constructor, an identifier will help
        setGender(true);

        personCount++;
    }

    // -------------------------------------------------- Getters and Setters ------------------------------------------------------
    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getGender(){
        if (gender) return "Male";
        return "Female";
    }

    public boolean setID(int _id){
        if (_id == id) return true;
        if (occupiedID.contains(_id)) return false;
        
        id = _id;
        occupiedID.add(_id);
        return true;
    }

    public boolean setName(String _name){
        String temp = Utils.normalizeName(_name);
        if (temp.isBlank()) return false;
        name = temp;
        return true;
    }

    public void setGender(boolean _gender){ // No return type because this method cannot possibly cause an error
        // No validation needed because _gender cannot be anything besides true or false
        gender = _gender;
    }

    public boolean setGender(String _gender){
        switch (_gender.toLowerCase().trim()) {
            case "male" -> setGender(true);
            case "female" -> setGender(false);
            default -> {
                return false;
            }
        }
        return true;
    }
}
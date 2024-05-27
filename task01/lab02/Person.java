package task01.lab02;

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
        if (!setName(_name)) {
            System.out.println("Name used in constructor is invalid.");
            setName("Person " + personCount);
        }
        setGender(_gender);

        personCount++;
    }
    public Person(int _id, String _name, String _gender){
        while(!setID(_id++));
        if (!setName(_name)) {
            System.out.println("Name used in constructor is invalid.");
            setName("Person " + personCount);
        }
        if (!setGender(_gender)) {
            System.out.println("Warning: invalid gender for constructor, setting \"male\" as gender.");
            setGender(true);
        }

        personCount++;
    }
    // Default constructor
    public Person(){
        int temp = 0;
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

        System.out.println("Setting " + _id + " as ID");

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

    // -------------------------------------------------------------- Methods -------------------------------------------------------------
    // Updating info
    public void scanInfo(){
        String inp;
        while ((inp = Utils.getLine("Enter ID: ", Utils.validations.vInt)).isEmpty() || !setID(Integer.parseInt(inp)))
            System.out.println("Only available integer IDs are allowed. ");
        while ((inp = Utils.getLine("Enter name: ")).isEmpty() || !setName(inp))
            System.out.print("Name cannot contain only special characters or be blank. ");
        // while ((inp = Utils.getLine("Enter Gender (male or female): ")).isEmpty() || !setGender(inp))
        //     System.out.print("Invalid gender. ");
        while ((inp = Utils.getLine("Enter Gender (true for male, false for female): ", Utils.validations.vBool)).isEmpty())
            System.out.print("Invalid gender. ");
        setGender(Boolean.parseBoolean(inp));
    }
    // Printing info
    public void printInfo(){
    System.out.println("\n"
                        + "-".repeat(17 + name.length())
                        + "\n| ID" + " ".repeat(id == 0 ? 0 : (int)(Math.log10(id)))
                        + "| Name" + " ".repeat(name.length() > 3? name.length() -3 : 0)
                        + "| Gender |");
    System.out.printf("| %d | %3s | %6s |\n", id, name, getGender());
   }
}
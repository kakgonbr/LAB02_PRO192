package task02.lab02;

import misc.Utils;

public class Test {
    
    public static void main(String[] args){
        Person person1 = new Person();
        scanInfo(person1);
        printInfo(person1);
    }
    
    // Updating info
    public static void scanInfo(Person person){
        String inp;
        while ((inp = Utils.getLine("Enter ID: ", Utils.validations.vInt)).isEmpty() || !person.setID(Integer.parseInt(inp)))
            System.out.println("Only available integer IDs are allowed. ");
        while ((inp = Utils.getLine("Enter name: ")).isEmpty() || !person.setName(inp))
            System.out.print("Name cannot contain only special characters or be blank. ");
        // while ((inp = Utils.getLine("Enter Gender (male or female): ")).isEmpty() || !person.setGender(inp))
        //     System.out.print("Invalid gender. ");
        while ((inp = Utils.getLine("Enter Gender (true for male, false for female): ", Utils.validations.vBool)).isEmpty())
            System.out.print("Invalid gender. ");
        person.setGender(Boolean.parseBoolean(inp));
    }
    // Printing info
    public static void printInfo(Person person){
    System.out.println("\n"
                        + "-".repeat(40)
                        + "\n| ID" + " ".repeat(person.getID() == 0 ? 0 : (int)(Math.log10(person.getID())))
                        + "| Name" + " ".repeat(person.getName().length() > 3? person.getName().length() -3 : 0)
                        + "| Gender |");
    System.out.printf("| %d | %3s | %6s |\n", person.getID(), person.getName(), person.getGender());

    }
}

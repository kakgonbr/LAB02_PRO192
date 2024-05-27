package task04.lab02;

import java.util.ArrayList;
import task03.lab02.Person;
import misc.Utils;

public class Test {
    static ArrayList<Person> people = new ArrayList<>();
    
    public static void main(String[] args){
        people.add(new Person());
        people.add(new Person());

        for (int i = 0; i < 2; i++){
            Person person = new Person();
            person.scanInfo();
            people.add(person);
        }

        sortName();

        for (final Person person : people)
            person.printInfo();

        String inp;
        int foundIndex;
        while ((inp = Utils.getLine("Enter name to search for: ")).isBlank());
        if ((foundIndex = findName(inp)) == -1)
            System.out.println("Couldn't find person with the name specified");
        else {
            System.out.print("Found person: ");
            people.get(foundIndex).printInfo();
        }
    }

    private static void sortName(){
        for (int i = 0; i < people.size() - 1; i++) { 
            int min_idx = i; 
            for (int j = i + 1; j < people.size(); j++) { 
                if (nameWeight(people.get(j).getName()) < nameWeight(people.get(min_idx).getName())) 
                    min_idx = j;
            } 

            Person temp = people.get(min_idx); 
            people.set(min_idx, people.get(i)); 
            people.set(i, temp);
        } 
    }

    private static double nameWeight(String name){

        String[] words = name.split("\\s");

        double wordWeight = 1.d;
        double totalWeight = .0d;

        for (int i = words.length - 1; i >= 0; i--){
            totalWeight += (words[i].toUpperCase().codePointAt(0) - 48) * wordWeight;
            wordWeight /= 100;
        }

        return totalWeight;
    }

    private static int findName(String substr){
        for (int i = 0; i < people.size(); i++){
            if (people.get(i).getName().toLowerCase().contains(substr.toLowerCase())) return i;
        }
        return -1;
    }
}

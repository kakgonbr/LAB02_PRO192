package task03.lab02;

public class Test {
    
    public static void main(String[] args){
        // 2 more objects of the Person class
        Person person2 = new Person(1, "Nguyen van a", true);
        Person person3 = new Person(2, "SJasjd njaskja dnj JSDNJnj dsakjksd", false);

        // Person array with length of 4
        Person[] perArr = new Person[4];
        // Assign the 2 objects to this array
        perArr[0] = person2;
        perArr[1] = person3;

        for (int i = 2; i < 4; i++){
            Person person = new Person();
            person.scanInfo();
            perArr[i] = person;
        }

        for (final Person person : perArr)
            person.printInfo();
    }
}

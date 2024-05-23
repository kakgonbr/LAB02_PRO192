package task01.lab02;

public class Test {
    
    public static void main(String[] args){
        Person person1 = new Person();

        person1.printInfo();

        Person person2 = new Person(2, "ss", "male");

        Person person3 = new Person(3, "sad yehsa jbsahj d", false);

        Person person4 = new Person(3, "NOOOOOOOOO", true);

        Person person5 = new Person();

        person2.printInfo();
        person3.printInfo();
        person4.printInfo();
        person5.printInfo();
    }
}

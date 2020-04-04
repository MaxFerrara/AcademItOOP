package name.max_ferrara.person_main;

import name.max_ferrara.person.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        Person person1 = new Person(25, "Max");
        Person person2 = new Person(48, "Victor");
        Person person3 = new Person(28, "Victor");
        Person person4 = new Person(21, "Lola");
        Person person5 = new Person(35, "Marina");
        Person person6 = new Person(19, "Mira");
        Person person7 = new Person(32, "Mira");

        List<Person> people = new ArrayList<>();

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);

        System.out.println(people);
    }
}

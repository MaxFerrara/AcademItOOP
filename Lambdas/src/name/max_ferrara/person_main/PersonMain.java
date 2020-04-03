package name.max_ferrara.person_main;

import name.max_ferrara.person.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class PersonMain {
    public static void main(String[] args) {
        Person person1 = new Person(25, "Max");
        Person person2 = new Person(48, "Victor");
        Person person3 = new Person(28, "Victor");
        Person person4 = new Person(21, "Lola");
        Person person5 = new Person(35, "Marina");
        Person person6 = new Person(19, "Mira");
        Person person7 = new Person(32, "Mira");

        //Object[] persons = {person1, person2, person3, person4, person5, person6, person7};
        //Arrays.stream(persons);
        //Stream<String> stream =
        //List<Object> persons = new List<>();

        //System.out.println(persons);
        //Arrays.stream(persons).distinct(p -> System.out.println(p));
    }
}

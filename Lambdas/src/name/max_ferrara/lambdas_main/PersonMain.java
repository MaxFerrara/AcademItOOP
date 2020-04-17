package name.max_ferrara.lambdas_main;

import name.max_ferrara.person.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonMain {
    public static void main(String[] args) {
        Person person1 = new Person(25, "Max");
        Person person2 = new Person(48, "Victor");
        Person person3 = new Person(28, "Victor");
        Person person4 = new Person(21, "Lola");
        Person person5 = new Person(35, "Marina");
        Person person6 = new Person(19, "Mira");
        Person person7 = new Person(32, "Mira");
        Person person8 = new Person(16, "Eva");
        Person person9 = new Person(14, "Alex");

        List<Person> persons = new ArrayList<>();

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);
        persons.add(person8);
        persons.add(person9);

        //начальный список
        System.out.println(persons);
        System.out.println();

        //А) получить список уникальных имен
        List<String> uniqueNames = persons.stream().map(Person::getName).distinct().collect(Collectors.toList());

        //Б) вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр.
        System.out.println("Names: " + String.join(", ", uniqueNames));
        System.out.println();


        //В) получить список людей младше 18, посчитать для них средний возраст
        List<Person> peopleUnder18 = persons.stream().filter(p -> p.getAge() < 18).collect(Collectors.toList());
        System.out.println(peopleUnder18);
        double averageAge = persons.stream().filter(p -> p.getAge() < 18).mapToInt(Person::getAge).average().getAsDouble();
        System.out.println(averageAge);
        System.out.println();

        //Г) при помощи группировки получить Map , в котором ключи имена, а значения средний возраст
        Map<String, Double> personsByMiddleAge = persons.stream().collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        System.out.println(personsByMiddleAge);
        System.out.println();

        //Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        Comparator<Person> comparator = Comparator.comparingInt(Person::getAge);
        List<Person> filtered3 = persons.stream().filter(p -> p.getAge() >= 20 && p.getAge() <= 40).sorted(comparator.reversed()).collect(Collectors.toList());
        System.out.println(filtered3);
    }
}

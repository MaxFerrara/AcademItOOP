package name.max_ferrara.lambdas_main;

import name.max_ferrara.person.Person;

import java.util.*;
import java.util.stream.Collectors;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person(25, "Max"),
                new Person(48, "Victor"),
                new Person(28, "Victor"),
                new Person(21, "Lola"),
                new Person(35, "Marina"),
                new Person(19, "Mira"),
                new Person(32, "Mira"),
                new Person(16, "Eva"),
                new Person(14, "Alex")
        ));

        //начальный список
        System.out.println(persons);
        System.out.println();

        //А) получить список уникальных имен
        List<String> uniqueNames = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        //Б) вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр.
        System.out.println(uniqueNames.stream().collect(Collectors.joining(", ", "Names: ", ".")));
        System.out.println();

        //В) получить список людей младше 18, посчитать для них средний возраст
        List<Person> peopleUnder18 = persons.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());

        System.out.println(peopleUnder18);

        double averageAge = persons.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.averagingDouble(Person::getAge));

        System.out.println(averageAge);
        System.out.println();

        //Г) при помощи группировки получить Map , в котором ключи имена, а значения средний возраст
        Map<String, Double> namesByAverageAge = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        System.out.println(namesByAverageAge);
        System.out.println();

        //Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        Comparator<Person> comparator = Comparator.comparingInt(Person::getAge);
        List<Person> personsWithAgeBetween20And45 = persons.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 40)
                .sorted(comparator.reversed())
                .collect(Collectors.toList());

        System.out.println(personsWithAgeBetween20And45);
    }
}

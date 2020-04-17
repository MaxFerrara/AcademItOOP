package name.max_ferrara.person;

public class Person {
    private String name;
    private int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Person name/age: %s/%s", name, age);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

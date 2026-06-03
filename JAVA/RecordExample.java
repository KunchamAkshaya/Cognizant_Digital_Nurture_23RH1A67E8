import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class RecordExample {

    public static void main(String[] args) {

        Person p1 = new Person("Akshay", 20);

        Person p2 = new Person("Priya", 17);

        Person p3 = new Person("Rahul", 25);

        System.out.println("Person Records:");

        System.out.println(p1);

        System.out.println(p2);

        System.out.println(p3);

        List<Person> people = new ArrayList<>();

        people.add(p1);
        people.add(p2);
        people.add(p3);

        List<Person> adults = people.stream()
                                    .filter(person -> person.age() >= 18)
                                    .collect(Collectors.toList());

        // Display filtered records
        System.out.println("\nPeople with age 18 or above:");

        adults.forEach(System.out::println);
    }
}
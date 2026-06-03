import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIExample {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);
        numbers.add(35);

        System.out.println("Original List:");
        System.out.println(numbers);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(num -> num % 2 == 0)
                                           .collect(Collectors.toList());

        // Display even numbers
        System.out.println("\nEven Numbers:");
        System.out.println(evenNumbers);
    }
}
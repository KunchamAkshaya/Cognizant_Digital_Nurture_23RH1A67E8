import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class LambdaExpressionExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Rahul");
        names.add("Akshay");
        names.add("Priya");
        names.add("Zara");
        names.add("Kiran");
        System.out.println("Original List:");
        System.out.println(names);
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("\nSorted List:");
        System.out.println(names);
    }
}
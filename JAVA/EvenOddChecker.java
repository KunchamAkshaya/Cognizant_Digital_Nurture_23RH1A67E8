import java.util.Scanner;
public class EvenOddChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number;
        System.out.print("Enter an integer: ");
        number = sc.nextInt();

        if(number % 2 == 0) {

            System.out.println(number + " is an Even number.");

        } else {

            System.out.println(number + " is an Odd number.");
        }

        sc.close();
    }
}
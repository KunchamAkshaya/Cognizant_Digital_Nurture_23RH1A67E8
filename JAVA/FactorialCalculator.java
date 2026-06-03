import java.util.Scanner;
public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        long factorial = 1;
        System.out.print("Enter a non-negative integer: ");
        number = sc.nextInt();
        if (number < 0) {

            System.out.println("Factorial is not defined for negative numbers.");

        } else {
            for (int i = 1; i <= number; i++) {

                factorial = factorial * i;
            }

            System.out.println("Factorial of " + number + " = " + factorial);
        }

        sc.close();
    }
}
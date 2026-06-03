import java.util.Scanner;
public class RecursiveFibonacci {
    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter a positive integer: ");
        n = sc.nextInt();

        if (n < 0) {

            System.out.println("Please enter a positive integer.");

        } else {

            System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
        }

        sc.close();
    }
}
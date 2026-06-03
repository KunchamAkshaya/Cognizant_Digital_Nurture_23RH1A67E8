import java.util.Scanner;
public class TryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, result;
        System.out.print("Enter first integer: ");
        num1 = sc.nextInt();
        System.out.print("Enter second integer: ");
        num2 = sc.nextInt();
        try {
            result = num1 / num2;
            System.out.println("Result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
        sc.close();
    }
}
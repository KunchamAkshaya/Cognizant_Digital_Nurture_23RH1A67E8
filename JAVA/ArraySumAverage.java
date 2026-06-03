import java.util.Scanner;
public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int sum = 0;
        double average;
        System.out.print("Enter the number of elements: ");
        n = sc.nextInt();
        int[] numbers = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            sum = sum + numbers[i];
        }
        average = (double) sum / n;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        sc.close();
    }
}
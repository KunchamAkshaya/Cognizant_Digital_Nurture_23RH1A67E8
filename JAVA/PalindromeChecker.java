import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String originalString = sc.nextLine();
        String cleanedString = originalString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedString = "";
        for (int i = cleanedString.length() - 1; i >= 0; i--) {
            reversedString += cleanedString.charAt(i);
        }
        if (cleanedString.equals(reversedString)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }
        sc.close();
    }
}
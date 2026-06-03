import java.util.Scanner;
public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String originalString = sc.nextLine();
        StringBuilder reversedString = new StringBuilder();
        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString.append(originalString.charAt(i));
        }
        System.out.println("Reversed string: " + reversedString);
        sc.close();
    }
}
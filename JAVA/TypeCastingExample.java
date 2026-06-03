public class TypeCastingExample {
    public static void main(String[] args) {
        double doubleValue = 45.67;
        int intValue = (int) doubleValue;
        System.out.println("Double value: " + doubleValue);
        System.out.println("After casting to int: " + intValue);
        int number = 25;
        double convertedDouble = (double) number;
        System.out.println("Integer value: " + number);
        System.out.println("After casting to double: " + convertedDouble);
    }
}
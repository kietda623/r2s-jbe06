package Session06;

import java.util.Locale;
import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner sc = new Scanner(System.in);

    public ScannerUtil() {}

    public static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = sc.nextLine().trim();

            if (!value.isEmpty()) return value;
            System.out.println("Value cannot be emtpy!");
        }
    }

    public static boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt + " (true/false): ");
            String value = sc.nextLine().trim().toLowerCase();

            if ("true".equals(value)) return true;
            if ("false".equals(value))  return false;

            System.out.println("Enter true or false!");
        }
    }

    public static short readPositiveShort(String prompt) {
        while (true) {
            System.out.print(prompt);
            String strValue = sc.nextLine().trim();

            try {
                short shortValue = Short.parseShort(strValue);

                if (shortValue > 0) return shortValue;
                System.out.println("Must be > 0");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    public static int readMenuChoice() {
        while (true) {
            System.out.print("Choose: ");
            String value = sc.nextLine().trim();

            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Enter a number");
            }
        }
    }
}

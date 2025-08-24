import java.util.Scanner;

// Utility class to handle user input validation
public class UserInputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    // Gets an integer within a valid range
    public static int getIntInput(String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value < min || value > max) throw new NumberFormatException();
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
            }
        }
    }

    // Gets a non-empty string input
    public static String getNonEmptyInput(String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("Input cannot be empty.");
            }
        } while (value.isEmpty());
        return value;
    }
}

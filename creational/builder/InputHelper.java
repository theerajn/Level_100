import java.util.Scanner;

// Helper class to get required input from user
public class InputHelper {
    public static String getRequiredInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                return input; // Return valid input
            }
            System.out.println("This field is required. Please enter a value.");
        }
    }
}

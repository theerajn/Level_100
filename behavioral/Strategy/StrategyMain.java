import java.util.InputMismatchException;
import java.util.Scanner;

// Client code: Demonstrates Strategy Design Pattern for Smart Irrigation System
public class StrategyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("===== Smart Irrigation System =====");
            int fieldArea = getValidatedInput(scanner, "Enter field area size (m²): ");
            int availableWater = getValidatedInput(scanner, "Enter available water in tank (liters): ");

            IrrigationContext context = new IrrigationContext();

            while (true) {
                System.out.println("\nChoose Irrigation Method:");
                System.out.println("1. Drip Irrigation");
                System.out.println("2. Sprinkler Irrigation");
                System.out.println("3. Flood Irrigation");
                System.out.println("4. Exit");

                int choice = getValidatedChoice(scanner, 1, 4);

                switch (choice) {
                    case 1:
                        context.setStrategy(new DripIrrigation());
                        break;
                    case 2:
                        context.setStrategy(new SprinklerIrrigation());
                        break;
                    case 3:
                        context.setStrategy(new FloodIrrigation());
                        break;
                    case 4:
                        System.out.println("Exiting Smart Irrigation System. ");
                        return;
                }

                // Execute selected strategy
                context.executeStrategy(fieldArea, availableWater);
            }
        } catch (InputMismatchException e) {
            System.out.println("Input error: Please enter numeric values only.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // Ensures scanner is always closed
            System.out.println("Scanner closed. Program terminated.");
        }
    }

    // Method to validate numeric input
    private static int getValidatedInput(Scanner scanner, String message) {
        int value;
        while (true) {
            try {
                System.out.print(message);
                value = scanner.nextInt();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear wrong input
            }
        }
        return value;
    }

    // Method to validate menu choice
    private static int getValidatedChoice(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            try {
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Please select a valid option between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear wrong input
            }
        }
        return choice;
    }
}

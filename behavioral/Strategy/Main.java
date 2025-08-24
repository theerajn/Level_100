import java.util.Scanner;

// Client code: Demonstrates Strategy Design Pattern for Smart Irrigation System
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                    scanner.close();
                    return;
            }

            // Execute selected strategy
            context.executeStrategy(fieldArea, availableWater);
        }
    }

    // Method to validate numeric input
    private static int getValidatedInput(Scanner scanner, String message) {
        int value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return value;
    }

    // Method to validate menu choice
    private static int getValidatedChoice(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Please select a valid option between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return choice;
    }
}

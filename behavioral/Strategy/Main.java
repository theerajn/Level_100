
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IrrigationContext context = new IrrigationContext();

        System.out.println("===== Smart Irrigation System =====");

        double areaSize = getValidatedInput(scanner, "Enter field area size (m²): ");
        double waterLevel = getValidatedInput(scanner, "Enter available water in tank (liters): ");

        while (true) {
            System.out.println("\nChoose Irrigation Method:");
            System.out.println("1. Drip Irrigation");
            System.out.println("2. Sprinkler Irrigation");
            System.out.println("3. Flood Irrigation");
            System.out.println("4. Exit");

            int choice = getValidatedChoice(scanner, 1, 4);

            switch (choice) {
                case 1 -> context.setStrategy(new DripIrrigation());
                case 2 -> context.setStrategy(new SprinklerIrrigation());
                case 3 -> context.setStrategy(new FloodIrrigation());
                case 4 -> {
                    System.out.println("Exiting Smart Irrigation System. 🌿");
                    scanner.close();
                    return;
                }
            }

            context.executeIrrigation(areaSize, waterLevel);
        }
    }

    private static double getValidatedInput(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value > 0) break;
                else System.out.println("Value must be greater than 0.");
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next(); // clear invalid input
            }
        }
        return value;
    }

    private static int getValidatedChoice(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) break;
                else System.out.println("Please choose a valid option (" + min + "-" + max + ").");
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
            }
        }
        return choice;
    }
}

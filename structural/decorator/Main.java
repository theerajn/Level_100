import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> appliedTransformations = new HashSet<>();

        System.out.println("=== ETL Pipeline: Data Cleaning ===");
        System.out.print("Enter your raw data for ETL processing: ");
        String inputData = scanner.nextLine();

        // Base ETL component with raw data
        ETLComponent etl = new BasicETLComponent(inputData);

        // Interactive menu for applying transformations dynamically
        while (true) {
            System.out.println("\nChoose a transformation to apply:");
            System.out.println("1. Trim whitespace");
            System.out.println("2. Remove special characters");
            System.out.println("3. Convert to uppercase");
            System.out.println("4. Apply all transformations");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine().trim();

            boolean applied = false;

            switch (choice) {
                case "1":
                    // Apply Trim if not already applied
                    if (appliedTransformations.add("trim")) {
                        etl = new TrimDecorator(etl);
                        applied = true;
                    } else {
                        System.out.println("Trim already applied.");
                    }
                    break;
                case "2":
                    // Apply Special Character Removal if not already applied
                    if (appliedTransformations.add("special")) {
                        etl = new SpecialCharRemovalDecorator(etl);
                        applied = true;
                    } else {
                        System.out.println("Special character removal already applied.");
                    }
                    break;
                case "3":
                    // Apply Uppercase if not already applied
                    if (appliedTransformations.add("upper")) {
                        etl = new UppercaseDecorator(etl);
                        applied = true;
                    } else {
                        System.out.println("Uppercase conversion already applied.");
                    }
                    break;
                case "4":
                    // Apply all transformations (only those not applied yet)
                    if (appliedTransformations.add("trim")) {
                        etl = new TrimDecorator(etl);
                        System.out.println("Trim applied.");
                    }
                    if (appliedTransformations.add("special")) {
                        etl = new SpecialCharRemovalDecorator(etl);
                        System.out.println("Special characters removed.");
                    }
                    if (appliedTransformations.add("upper")) {
                        etl = new UppercaseDecorator(etl);
                        System.out.println("Converted to uppercase.");
                    }
                    System.out.println("Final transformed data: " + etl.process());
                    continue; 
                case "5":
                    System.out.println("Exiting ETL processing.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            // Show intermediate result after applying transformation
            if (applied) {
                System.out.println("Intermediate result: " + etl.process());
            }
        }
    }
}

import java.util.Scanner;

// Client code to demonstrate Prototype Pattern
public class PrototypeMain {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            // Predefined car models
            Car sportsModel = new Car("Sports", "V8", "Red", true, true);
            Car ecoModel = new Car("Eco", "Hybrid", "Green", false, true);

            System.out.println("Available car models to clone:");
            System.out.println("1. Sports Model");
            System.out.println("2. Eco Model");

            Car baseCar = null;

            // Let user choose a base model
            while (baseCar == null) {
                try {
                    System.out.print("Choose a model to clone (1 or 2): ");
                    String input = scanner.nextLine().trim();

                    if (input.equals("1")) {
                        baseCar = sportsModel;
                    } else if (input.equals("2")) {
                        baseCar = ecoModel;
                    } else {
                        System.out.println("Invalid choice. Please enter 1 or 2.");
                    }
                } catch (Exception e) {
                    System.err.println("Error reading input: " + e.getMessage());
                }
            }

            // Clone the chosen model
            Car clonedCar = null;
            try {
                clonedCar = baseCar.cloneCar();
            } catch (Exception e) {
                System.err.println("Error while cloning: " + e.getMessage());
            }

            if (clonedCar != null) {
                try {
                    // Allow customization of cloned car
                    System.out.print("Enter new color for the cloned car (current: " + clonedCar.getColor() + "): ");
                    String newColor = scanner.nextLine().trim();
                    if (!newColor.isEmpty()) {
                        clonedCar.setColor(newColor);
                    }
                } catch (Exception e) {
                    System.err.println("Error setting color: " + e.getMessage());
                }

                while (true) {
                    try {
                        System.out.print("Add sunroof? (yes/no, current: " + (clonedCar.hasSunroof() ? "yes" : "no") + "): ");
                        String sunroofInput = scanner.nextLine().trim().toLowerCase();

                        if (sunroofInput.equals("yes")) {
                            clonedCar.setSunroof(true);
                            break;
                        } else if (sunroofInput.equals("no")) {
                            clonedCar.setSunroof(false);
                            break;
                        } else if (sunroofInput.isEmpty()) {
                            break;
                        } else {
                            System.out.println("Please enter 'yes' or 'no' (or press Enter to keep current setting).");
                        }
                    } catch (Exception e) {
                        System.err.println("Error setting sunroof: " + e.getMessage());
                    }
                }

                // Show results
                try {
                    System.out.println("\nOriginal Model: " + baseCar);
                    System.out.println("Cloned & Customized Car: " + clonedCar);
                } catch (Exception e) {
                    System.err.println("Error displaying results: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            if (scanner != null) {
                try {
                    scanner.close();
                } catch (Exception e) {
                    System.err.println("Error closing scanner: " + e.getMessage());
                }
            }
        }
    }
}

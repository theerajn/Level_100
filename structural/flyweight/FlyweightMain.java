import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Client code: Demonstrates Flyweight usage for vehicles
public class FlyweightMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            System.out.println("Welcome to the City Traffic Monitoring System.");
            System.out.print("How many vehicles do you want to add? ");
            int count = Integer.parseInt(scanner.nextLine());

            // Collect user input for multiple vehicles
            for (int i = 0; i < count; i++) {
                System.out.println("\nVehicle " + (i + 1) + ":");
                System.out.print("Enter vehicle type (e.g., Car, Bus, Truck): ");
                String type = scanner.nextLine();

                System.out.print("Enter icon to represent this vehicle (e.g., C, B, T): ");
                String icon = scanner.nextLine();

                System.out.print("Enter X coordinate: ");
                int x = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter Y coordinate: ");
                int y = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter direction (e.g., North, East, South, West): ");
                String direction = scanner.nextLine();

                // Reuse VehicleType (Flyweight) instead of creating new object each time
                VehicleType vehicleType = VehicleFactory.getVehicleType(type, icon);
                vehicles.add(new Vehicle(x, y, direction, vehicleType));
            }

            // Render all vehicles
            System.out.println("\n--- Rendering All Vehicles ---");
            for (Vehicle v : vehicles) {
                v.draw();
            }

            // Show number of unique vehicle types (Flyweights)
            System.out.println("\nUnique vehicle types used: " + VehicleFactory.totalTypes());

        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Please restart and enter valid numeric values.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

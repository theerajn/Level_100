import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Client code
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.println("Welcome to the City Traffic Monitoring System.");
        System.out.print("How many vehicles do you want to add? ");
        int count = Integer.parseInt(scanner.nextLine());

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

            VehicleType vehicleType = VehicleFactory.getVehicleType(type, icon);
            vehicles.add(new Vehicle(x, y, direction, vehicleType));
        }

        System.out.println("\n--- Rendering All Vehicles ---");
        for (Vehicle v : vehicles) {
            v.draw();
        }

        System.out.println("\nUnique vehicle types used: " + VehicleFactory.totalTypes());

        scanner.close();
    }
}

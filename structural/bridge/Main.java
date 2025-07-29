import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Choose Vehicle Type:");
        System.out.println("1. Car");
        System.out.println("2. Truck");
        System.out.print("Enter choice: ");
        int vehicleChoice = Integer.parseInt(scanner.nextLine());

        System.out.println("\nChoose Engine Type:");
        System.out.println("1. Petrol Engine");
        System.out.println("2. Diesel Engine");
        System.out.println("3. Electric Motor");
        System.out.print("Enter choice: ");
        int engineChoice = Integer.parseInt(scanner.nextLine());

        Engine engine = null;
        switch (engineChoice) {
            case 1: engine = new PetrolEngine(); break;
            case 2: engine = new DieselEngine(); break;
            case 3: engine = new ElectricMotor(); break;
            default:
                System.out.println("Invalid engine choice. Defaulting to Petrol Engine.");
                engine = new PetrolEngine();
        }

        Vehicle vehicle;
        switch (vehicleChoice) {
            case 1: vehicle = new Car(engine); break;
            case 2: vehicle = new Truck(engine); break;
            default:
                System.out.println("Invalid vehicle choice. Defaulting to Car.");
                vehicle = new Car(engine);
        }

        System.out.println("\nStarting vehicle...");
        vehicle.startEngine();
        vehicle.drive();
        vehicle.stopEngine();
        System.out.println("Vehicle stopped.");
    }
}

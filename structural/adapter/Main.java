import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Charger Adapter Demo ===");
        System.out.println("1. Use MicroUSB charger directly (Expected to fail)");
        System.out.println("2. Use MicroUSB charger with Type-C Adapter (Works)");
        System.out.print("Enter choice (1 or 2): ");

        int choice = Integer.parseInt(scanner.nextLine());

        MicroUSBCharger microUSB = new MicroUSBCharger();
        Phone phone = new Phone();
        WrongPhone legacyPhone = new WrongPhone();

        switch (choice) {
            case 1:
                legacyPhone.chargeDirectly(microUSB);
                break;
            case 2:
                USBTypeC adapter = new MicroUSBtoTypeCAdapter(microUSB);
                phone.charge(adapter);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
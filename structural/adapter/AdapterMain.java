// Client code: Controls smart devices via a uniform interface (SmartDevice) without worrying about their specific implementations
import java.util.*;

public class AdapterMain {
    private static Map<Integer, SmartDevice> devices = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        devices.put(1, new SmartPlugAdapter());
        devices.put(2, new SmartBulbAdapter());

        while (true) {
            System.out.println("\nSmart Home Device Controller");
            System.out.println("1. Turn ON Device");
            System.out.println("2. Turn OFF Device");
            System.out.println("3. Exit");
            System.out.println("4. Check Device Status");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    handleDeviceOperation(true);
                    break;
                case "2":
                    handleDeviceOperation(false);
                    break;
                case "3":
                    System.out.println("Exiting");
                    return;
                case "4":
                    showDeviceStatus();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Handles turning a device ON or OFF
    private static void handleDeviceOperation(boolean turnOn) {
        System.out.println("\nAvailable Devices:");
        devices.forEach((key, device) -> {
        System.out.println(key + ". " + device.getDeviceName());
    });

        System.out.print("Select device number: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            SmartDevice device = devices.get(choice);
            if (device != null) {
                if (turnOn) {
                    device.turnOn();
                } else {
                    device.turnOff();
                }
            } else {
                System.out.println("Invalid device number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    // Displays current status of all devices
    private static void showDeviceStatus() {
        try {
            System.out.println("\nDevice Status:");
            for (SmartDevice device : devices.values()) {
                System.out.println(device.getDeviceName() + " is currently " + (device.isOn() ? "ON" : "OFF"));
            }
        } catch (Exception e) {
            System.out.println("Error fetching device status: " + e.getMessage());
        }
    }

}

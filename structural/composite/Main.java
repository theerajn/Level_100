import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Sensor> allSensors = new HashMap<>();
    private static final Map<String, SensorGroup> allGroups = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("=== IoT Device Management System ===");

        while (true) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add Sensor");
            System.out.println("2. Create Sensor Group");
            System.out.println("3. Add Sensor/Group to Group");
            System.out.println("4. Operate on Group");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addSensor();
                case "2" -> createGroup();
                case "3" -> addSensorToGroup();
                case "4" -> operateGroup();
                case "0" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addSensor() {
        System.out.print("Enter Sensor ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty() || allSensors.containsKey(id)) {
            System.out.println("Invalid or duplicate Sensor ID.");
            return;
        }

        System.out.print("Enter Sensor Type (TEMPERATURE, HUMIDITY, SMOKE, PRESSURE): ");
        String typeInput = scanner.nextLine().trim().toUpperCase();
        try {
            Sensor.SensorType type = Sensor.SensorType.valueOf(typeInput);
            Sensor sensor = new Sensor(id, type);
            allSensors.put(id, sensor);
            System.out.println("Sensor added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid sensor type.");
        }
    }

    private static void createGroup() {
        System.out.print("Enter Group Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty() || allGroups.containsKey(name)) {
            System.out.println("Invalid or duplicate group name.");
            return;
        }
        SensorGroup group = new SensorGroup(name);
        allGroups.put(name, group);
        System.out.println("Group created successfully.");
    }

    private static void addSensorToGroup() {
        System.out.print("Enter Target Group Name: ");
        String groupName = scanner.nextLine().trim();
        SensorGroup group = allGroups.get(groupName);
        if (group == null) {
            System.out.println("Group not found.");
            return;
        }

        System.out.print("Enter Sensor ID or Group Name to Add: ");
        String id = scanner.nextLine().trim();

        if (allSensors.containsKey(id)) {
            group.addComponent(allSensors.get(id));
            System.out.println("Sensor added to group.");
        } else if (allGroups.containsKey(id)) {
            if (id.equals(groupName)) {
                System.out.println("Cannot add a group to itself.");
            } else {
                group.addComponent(allGroups.get(id));
                System.out.println("Sub-group added.");
            }
        } else {
            System.out.println("No such sensor or group found.");
        }
    }

    private static void operateGroup() {
        System.out.print("Enter Group Name to Operate On: ");
        String groupName = scanner.nextLine().trim();
        SensorGroup group = allGroups.get(groupName);
        if (group == null) {
            System.out.println("Group not found.");
            return;
        }

        while (true) {
            System.out.println("\n--- Group: " + groupName + " Operations ---");
            System.out.println("1. Show Status");
            System.out.println("2. Update Firmware");
            System.out.println("3. Collect Data");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> group.status();
                case "2" -> group.updateFirmware();
                case "3" -> group.collectData();
                case "0" -> { return; 
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

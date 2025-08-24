import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StreamChangeCollection stream = new StreamChangeCollection();

    public static void main(String[] args) {
        System.out.println("=== Snowflake Stream Change Iterator (Simulation) ===");

        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = UserInputHelper.getIntInput("Choose an option: ", 1, 4);
            switch (choice) {
                case 1:
                    simulateStreamData();
                    break;
                case 2:
                    iterateOverChanges();
                    break;
                case 3:
                    stream.clear();
                    System.out.println("Cleared all stream changes.");
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n------ MENU ------");
        System.out.println("1. Simulate stream change");
        System.out.println("2. Iterate over stream changes");
        System.out.println("3. Clear stream changes");
        System.out.println("4. Exit");
    }

    private static void simulateStreamData() {
        String table = UserInputHelper.getNonEmptyInput("Enter table name: ");
        String operation;
        while (true) {
            operation = UserInputHelper.getNonEmptyInput("Enter operation (INSERT/UPDATE/DELETE): ").toUpperCase();
            if (operation.equals("INSERT") || operation.equals("UPDATE") || operation.equals("DELETE")) break;
            System.out.println("Invalid operation. Try again.");
        }
        String data = UserInputHelper.getNonEmptyInput("Enter changed data (JSON or CSV format): ");
        stream.addChange(new StreamChange(table, operation, data));
        System.out.println("Stream change added.");
    }

    private static void iterateOverChanges() {
        if (stream.isEmpty()) {
            System.out.println("No stream changes to iterate.");
            return;
        }

        StreamChangeIterator iterator = stream.iterator();
        System.out.println("Iterating over changes:");
        while (iterator.hasNext()) {
            StreamChange change = iterator.next();
            System.out.println(change);
        }
    }
}

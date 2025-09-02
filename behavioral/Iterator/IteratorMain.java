// Client code: simulates Snowflake stream changes and uses iterator to traverse them
public class IteratorMain {
    private static final StreamChangeCollection stream = new StreamChangeCollection();

    public static void main(String[] args) {
        System.out.println("=== Snowflake Stream Change Iterator (Simulation) ===");

        boolean exit = false;
        while (!exit) {
            try {
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
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    // Prints the menu options
    private static void printMenu() {
        System.out.println("\n------ MENU ------");
        System.out.println("1. Simulate stream change");
        System.out.println("2. Iterate over stream changes");
        System.out.println("3. Clear stream changes");
        System.out.println("4. Exit");
    }

    // Simulates adding stream changes with validation
    private static void simulateStreamData() {
        try {
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
        } catch (Exception e) {
            System.out.println("Error while simulating stream data: " + e.getMessage());
        }
    }

    // Uses iterator to traverse through the list of stream changes
    private static void iterateOverChanges() {
        try {
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
        } catch (Exception e) {
            System.out.println("Error while iterating: " + e.getMessage());
        }
    }
}

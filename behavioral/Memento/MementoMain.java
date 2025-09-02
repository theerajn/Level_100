import java.util.Scanner;

// Client: Provides a menu for interacting with the database and caretaker
public class MementoMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database db = new Database();
        Caretaker caretaker = new Caretaker();

        while (true) {
            try {
                System.out.println("\n===== DATABASE MENU =====");
                System.out.println("1. Add Record");
                System.out.println("2. View Records");
                System.out.println("3. Rollback Last Change");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                String choice = sc.nextLine().trim();

                switch (choice) {
                    case "1":
                        System.out.print("Enter record (non-empty): ");
                        String record = sc.nextLine().trim();

                        if (record.isEmpty()) {
                            System.out.println("Invalid input! Record cannot be empty.");
                            break;
                        }

                        // Save current state before making changes
                        caretaker.saveMemento(db.saveStateToMemento());
                        db.addRecord(record);
                        break;

                    case "2":
                        db.showRecords();
                        break;

                    case "3":
                        // Get last saved state and restore if available
                        DatabaseMemento lastState = caretaker.getLastMemento();
                        if (lastState != null) {
                            db.restoreFromMemento(lastState);
                        } else {
                            System.out.println("No previous state available to rollback!");
                        }
                        break;

                    case "4":
                        System.out.println("Exiting program...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Please select 1-4.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

// Originator: The database that can save/restore its state
public class Database {
    private List<String> records = new ArrayList<>();

    // Add a new record
    public void addRecord(String record) {
        records.add(record);
        System.out.println("Record added successfully!");
    }

    // Display all records
    public void showRecords() {
        if (records.isEmpty()) {
            System.out.println("Database is empty.");
        } else {
            System.out.println("Database Records:");
            for (int i = 0; i < records.size(); i++) {
                System.out.println((i + 1) + ". " + records.get(i));
            }
        }
    }

    // Save current state to a memento (deep copy of records)
    public DatabaseMemento saveStateToMemento() {
        return new DatabaseMemento(new ArrayList<>(records));
    }

    // Restore state from a memento
    public void restoreFromMemento(DatabaseMemento memento) {
        records = new ArrayList<>(memento.getSavedState());
        System.out.println("Database rolled back successfully!");
    }
}

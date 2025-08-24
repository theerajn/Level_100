import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<String> records = new ArrayList<>();

    public void addRecord(String record) {
        records.add(record);
        System.out.println("Record added successfully!");
    }

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

    public DatabaseMemento saveStateToMemento() {
        return new DatabaseMemento(new ArrayList<>(records));
    }

    public void restoreFromMemento(DatabaseMemento memento) {
        records = new ArrayList<>(memento.getSavedState());
        System.out.println("Database rolled back successfully!");
    }
}

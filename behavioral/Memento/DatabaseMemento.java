import java.util.List;

// Memento: Stores a snapshot of the database state
public class DatabaseMemento {
    private final List<String> state;

    public DatabaseMemento(List<String> state) {
        this.state = state;
    }

    // Returns saved state
    public List<String> getSavedState() {
        return state;
    }
}

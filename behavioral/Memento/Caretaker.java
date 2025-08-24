import java.util.Stack;

// Caretaker: Manages saving and restoring mementos (history of database states)
public class Caretaker {
    private Stack<DatabaseMemento> mementoStack = new Stack<>();

    // Save a database state (push to stack)
    public void saveMemento(DatabaseMemento memento) {
        mementoStack.push(memento);
    }

    // Retrieve last saved state (pop from stack)
    public DatabaseMemento getLastMemento() {
        if (!mementoStack.isEmpty()) {
            return mementoStack.pop();
        }
        System.out.println("No previous state available for rollback!");
        return null;
    }
}

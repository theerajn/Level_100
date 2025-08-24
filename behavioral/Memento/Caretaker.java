import java.util.Stack;

public class Caretaker {
    private Stack<DatabaseMemento> mementoStack = new Stack<>();

    public void saveMemento(DatabaseMemento memento) {
        mementoStack.push(memento);
    }

    public DatabaseMemento getLastMemento() {
        if (!mementoStack.isEmpty()) {
            return mementoStack.pop();
        }
        System.out.println("No previous state available for rollback!");
        return null;
    }
}

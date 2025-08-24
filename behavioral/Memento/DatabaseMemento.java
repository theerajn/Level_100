import java.util.List;

public class DatabaseMemento {
    private final List<String> state;

    public DatabaseMemento(List<String> state) {
        this.state = state;
    }

    public List<String> getSavedState() {
        return state;
    }
}

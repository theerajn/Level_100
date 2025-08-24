import java.util.List;

// Concrete Iterator: iterates over stream changes in sequence
public class StreamChangeIterator {
    private List<StreamChange> changes;
    private int position = 0;

    public StreamChangeIterator(List<StreamChange> changes) {
        this.changes = changes;
    }

    public boolean hasNext() {
        return position < changes.size();
    }

    public StreamChange next() {
        return changes.get(position++);
    }
}

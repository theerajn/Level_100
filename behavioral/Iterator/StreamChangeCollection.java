import java.util.ArrayList;
import java.util.List;

public class StreamChangeCollection {
    private List<StreamChange> changes = new ArrayList<>();

    public void addChange(StreamChange change) {
        changes.add(change);
    }

    public StreamChangeIterator iterator() {
        return new StreamChangeIterator(changes);
    }

    public boolean isEmpty() {
        return changes.isEmpty();
    }

    public void clear() {
        changes.clear();
    }
}

// Concrete product: Word Writer
public class WordWriter implements DocumentWriter {
    public void write(String filename) { System.out.println("Writing Word file: " + filename); }
}

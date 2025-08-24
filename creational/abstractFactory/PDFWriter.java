// Concrete product: PDF Writer
public class PDFWriter implements DocumentWriter {
    public void write(String filename) { System.out.println("Writing PDF file: " + filename); }
}

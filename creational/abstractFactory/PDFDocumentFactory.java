

public class PDFDocumentFactory implements DocumentFactory {
    public DocumentReader createReader() {
        return new PDFReader();
    }

    public DocumentWriter createWriter() {
        return new PDFWriter();
    }

    public Formatter createFormatter() {
        return new PDFFormatter();
    }
}

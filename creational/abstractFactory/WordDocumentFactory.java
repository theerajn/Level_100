// Concrete factory for Word documents
public class WordDocumentFactory implements DocumentFactory {
    public DocumentReader createReader() {
        return new WordReader();
    }

    public DocumentWriter createWriter() {
        return new WordWriter();
    }

    public Formatter createFormatter() {
        return new WordFormatter();
    }
}

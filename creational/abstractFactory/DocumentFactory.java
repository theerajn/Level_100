

public interface DocumentFactory {
    DocumentReader createReader();
    DocumentWriter createWriter();
    Formatter createFormatter();
}

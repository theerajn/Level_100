// Abstract Factory interface: declares methods to create related objects (Reader, Writer, Formatter) for a document type
public interface DocumentFactory {
    DocumentReader createReader();
    DocumentWriter createWriter();
    Formatter createFormatter();
}

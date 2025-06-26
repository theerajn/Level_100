public class DocumentFactoryProvider {
    public static DocumentFactory getFactory(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Document type cannot be null or empty");
        }

        switch (type.toLowerCase()) {
            case "pdf":
                return new PDFDocumentFactory();
            case "word":
                return new WordDocumentFactory();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}

// Client code: Uses factory to create Reader, Writer, and Formatter without depending on concrete classes
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentFactory factory = null;

        // Get document type from user
        while (factory == null) {
            System.out.print("Choose document type (pdf/word): ");
            String docType = scanner.nextLine().trim();

            try {
                factory = DocumentFactoryProvider.getFactory(docType);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter 'pdf' or 'word'.");
            }
        }

        // Get input, output filenames and content
        String inputFile = "";
        while (inputFile.trim().isEmpty()) {
            System.out.print("Enter input filename: ");
            inputFile = scanner.nextLine();
            if (inputFile.trim().isEmpty()) {
                System.out.println("Input filename cannot be empty. Please enter a valid filename.");
            }
        }

        String outputFile = "";
        while (outputFile.trim().isEmpty()) {
            System.out.print("Enter output filename: ");
            outputFile = scanner.nextLine();
            if (outputFile.trim().isEmpty()) {
                System.out.println("Output filename cannot be empty. Please enter a valid filename.");
            }
        }

        String content = "";
        while (content.trim().isEmpty()) {
            System.out.print("Enter content to format: ");
            content = scanner.nextLine();
            if (content.trim().isEmpty()) {
                System.out.println("Content cannot be empty. Please enter valid content.");
            }
        }

        // Create products using abstract factory
        DocumentReader reader = factory.createReader();
        DocumentWriter writer = factory.createWriter();
        Formatter formatter = factory.createFormatter();

        // Use the products
        reader.read(inputFile);
        formatter.format(content);
        writer.write(outputFile);

        scanner.close();
    }
}

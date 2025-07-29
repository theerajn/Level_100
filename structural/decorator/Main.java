import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter message to save: ");
        String message = scanner.nextLine();
        String fileName = "secure-data.txt";

        // Wrap in decorators: Compression -> Encryption -> Base64 
        DataSource dataSource = new Base64Decorator(
                                    new EncryptionDecorator(
                                        new CompressionDecorator(
                                            new FileDataSource(fileName)
                                        )
                                    )
                                );

        dataSource.write(message);

        System.out.println("\nData saved successfully!");
        System.out.println("Reading back the data...\n");

        String readBack = dataSource.read();
        System.out.println("Recovered message: " + readBack);

        scanner.close();
    }
}

import java.util.Scanner;

// Client class to demonstrate Factory Pattern usage
public class FactoryMain {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            Notification notification = null;
            String type;

            // Loop until user enters a valid notification type
            while (notification == null) {
                try {
                    System.out.print("Enter notification type (email/sms/push): ");
                    type = scanner.nextLine();

                    // Use Factory to create the appropriate Notification object
                    notification = NotificationFactory.createNotification(type);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Please enter a valid notification type.");
                } catch (Exception e) {
                    System.err.println("Unexpected error while choosing notification type: " + e.getMessage());
                }
            }

            String message = "";
            // Ensure message is not empty
            while (message == null || message.trim().isEmpty()) {
                try {
                    System.out.print("Enter message: ");
                    message = scanner.nextLine();
                    if (message == null || message.trim().isEmpty()) {
                        System.out.println("Message cannot be empty. Please enter a valid message.");
                    }
                } catch (Exception e) {
                    System.err.println("Error while reading message: " + e.getMessage());
                }
            }

            try {
                // Send notification using the chosen notification type
                notification.send(message);
            } catch (Exception e) {
                System.err.println("Error while sending notification: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            if (scanner != null) {
                try {
                    scanner.close();
                } catch (Exception e) {
                    System.err.println("Error closing scanner: " + e.getMessage());
                }
            }
        }
    }
}

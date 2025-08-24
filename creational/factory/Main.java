import java.util.Scanner;

// Client class to demonstrate Factory Pattern usage
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Notification notification = null;
        String type;

        // Loop until user enters a valid notification type
        while (notification == null) {
            System.out.print("Enter notification type (email/sms/push): ");
            type = scanner.nextLine();

            try {
                // Use Factory to create the appropriate Notification object
                notification = NotificationFactory.createNotification(type);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter a valid notification type.");
            }
        }

        String message = "";
        // Ensure message is not empty
        while (message == null || message.trim().isEmpty()) {
            System.out.print("Enter message: ");
            message = scanner.nextLine();
            if (message == null || message.trim().isEmpty()) {
                System.out.println("Message cannot be empty. Please enter a valid message.");
            }
        }

        // Send notification using the chosen notification type
        notification.send(message);
        scanner.close();
    }
}

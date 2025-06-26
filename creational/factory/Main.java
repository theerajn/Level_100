import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Notification notification = null;
        String type;

        while (notification == null) {
            System.out.print("Enter notification type (email/sms/push): ");
            type = scanner.nextLine();

            try {
                notification = NotificationFactory.createNotification(type);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter a valid notification type.");
            }
        }

        String message = "";
        while (message == null || message.trim().isEmpty()) {
            System.out.print("Enter message: ");
            message = scanner.nextLine();
            if (message == null || message.trim().isEmpty()) {
                System.out.println("Message cannot be empty. Please enter a valid message.");
            }
        }

        notification.send(message);
        scanner.close();
    }
}

// Factory class responsible for creating instances of different Notification types
public class NotificationFactory {

    // Factory method to create Notification objects based on type
    public static Notification createNotification(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Notification type cannot be null or empty");
        }

        // Decide which concrete class to return based on input
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}

// Concrete implementation of Notification interface for Push Notification
public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Push notification sent: " + message);
    }
}

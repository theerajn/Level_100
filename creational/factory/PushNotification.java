public class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Push notification sent: " + message);
    }
}
// Concrete filter that blocks emails from suspicious senders.
public class SenderReputationFilter extends Filter {
    @Override
    public void handle(Email1 email) {
        // Block emails from specific suspicious domain
        if (email.getSender().toLowerCase().endsWith("@suspicious.com")) {
            System.out.println("Email blocked: Suspicious sender.");
        } else if (next != null) {
            next.handle(email);
        }
    }
}

public class SenderReputationFilter extends Filter {
    @Override
    public void handle(Email email) {
        if (email.getSender().toLowerCase().endsWith("@suspicious.com")) {
            System.out.println("Email blocked: Suspicious sender.");
        } else if (next != null) {
            next.handle(email);
        }
    }
}

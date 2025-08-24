public class ManualReviewFilter extends Filter {
    @Override
    public void handle(Email email) {
        System.out.println("Email passed automated filters. Sent for manual review.");
    }
}

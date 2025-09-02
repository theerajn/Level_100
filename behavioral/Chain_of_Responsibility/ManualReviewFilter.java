// Final filter in the chain. 
// If no automated filter blocks the email, it is sent for manual review.
public class ManualReviewFilter extends Filter {
    @Override
    public void handle(Email1 email) {
        System.out.println("Email passed automated filters. Sent for manual review.");
    }
}

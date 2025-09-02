import java.util.Scanner;

// Client code that simulates the spam filtering system.
public class CORMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Spam Email Filtering System ===");

        while (true) {
            // Collect email details
            System.out.println("\nEnter email details:");
            System.out.print("Subject: ");
            String subject = scanner.nextLine().trim();

            System.out.print("Body: ");
            String body = scanner.nextLine().trim();

            System.out.print("Sender Email: ");
            String sender = scanner.nextLine().trim();

            // Validate inputs
            if (subject.isEmpty() || body.isEmpty() || sender.isEmpty()) {
                System.out.println("All fields are required. Please try again.");
                continue;
            }

            Email1 email = new Email1(subject, body, sender);

            // Build Chain of Responsibility
            Filter keywordFilter = new KeywordFilter();
            Filter reputationFilter = new SenderReputationFilter();
            Filter manualReviewFilter = new ManualReviewFilter();

            keywordFilter.setNext(reputationFilter);
            reputationFilter.setNext(manualReviewFilter);

            // Start processing the email through the chain
            keywordFilter.handle(email);

            // Ask user if they want to continue
            System.out.print("\nDo you want to check another email? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("System exited..");
    }
}

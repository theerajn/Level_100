import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Spam Email Filtering System ===");

        while (true) {
            System.out.println("\nEnter email details:");
            System.out.print("Subject: ");
            String subject = scanner.nextLine().trim();

            System.out.print("Body: ");
            String body = scanner.nextLine().trim();

            System.out.print("Sender Email: ");
            String sender = scanner.nextLine().trim();

            if (subject.isEmpty() || body.isEmpty() || sender.isEmpty()) {
                System.out.println("All fields are required. Please try again.");
                continue;
            }

            Email email = new Email(subject, body, sender);

            // Build chain
            Filter keywordFilter = new KeywordFilter();
            Filter reputationFilter = new SenderReputationFilter();
            Filter manualReviewFilter = new ManualReviewFilter();

            keywordFilter.setNext(reputationFilter);
            reputationFilter.setNext(manualReviewFilter);

            keywordFilter.handle(email);

            System.out.print("\nDo you want to check another email? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("System exited.");
    }
}

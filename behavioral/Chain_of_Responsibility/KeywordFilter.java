// Concrete filter that blocks emails containing suspicious spam keywords.
public class KeywordFilter extends Filter {

    // Common spam-related keywords
    private static final String[] SPAM_KEYWORDS = {
        "virus", "malware", "trojan", "spyware", "hacked",
        "free money", "win a prize", "lottery", "jackpot", "winner", "free",
        "gift", "urgent", "act now", "limited offer", "exclusive deal",
        "100% free", "click here", "buy now", "cheap", "order now",
        "risk-free", "credit card", "account suspended", "password reset",
        "congratulations", "you're selected", "guaranteed", "extra cash",
        "work from home", "no cost", "easy income", "cash bonus",
        "investment opportunity", "miracle", "weight loss", "earn money",
        "limited time", "instant", "call now", "apply now", "don’t delete",
        "pre-approved", "winner", "bargain", "double your income",
        "no experience required", "financial freedom", "money back",
        "best deal", "get rich", "trial offer", "act immediately"
    };

    @Override
    public void handle(Email1 email) {
        String subject = email.getSubject().toLowerCase();
        String body = email.getBody().toLowerCase();

        // Check if subject/body contains any spam keyword
        for (String keyword : SPAM_KEYWORDS) {
            if (subject.contains(keyword) || body.contains(keyword)) {
                System.out.println("Email blocked: Suspicious keyword found (" + keyword + ")");
                return; // Stop chain if spam detected
            }
        }

        // Pass to next filter if no keyword detected
        if (next != null) {
            next.handle(email);
        }
    }
}

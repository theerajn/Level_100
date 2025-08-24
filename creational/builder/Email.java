// Product class representing the final Email object
public class Email {
    private final String to;
    private final String subject;
    private final String body;
    private final String cc;
    private final String bcc;
    private final String attachment;

    // Constructor is private to enforce creation via EmailBuilder
    public Email(EmailBuilder builder) {
        this.to = builder.to;
        this.subject = builder.subject;
        this.body = builder.body;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
        this.attachment = builder.attachment;
    }

    @Override
    public String toString() {
        return "Email Details:\n" +
                "To        : " + to + "\n" +
                "Subject   : " + subject + "\n" +
                "Body      : " + body + "\n" +
                "CC        : " + (cc != null ? cc : "None") + "\n" +
                "BCC       : " + (bcc != null ? bcc : "None") + "\n" +
                "Attachment: " + (attachment != null ? attachment : "None");
    }
}

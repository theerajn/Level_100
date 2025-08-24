// Builder class to construct Email objects step by step
public class EmailBuilder {
    String to;
    String subject;
    String body;
    String cc;
    String bcc;
    String attachment;

    public EmailBuilder setTo(String to) {
        this.to = to;
        return this; // Enable method chaining
    }

    public EmailBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public EmailBuilder setCc(String cc) {
        this.cc = cc;
        return this;
    }

    public EmailBuilder setBcc(String bcc) {
        this.bcc = bcc;
        return this;
    }

    public EmailBuilder setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    // Build method validates required fields and returns the Email object
    public Email build() {
        if (to == null || to.trim().isEmpty() ||
            subject == null || subject.trim().isEmpty() ||
            body == null || body.trim().isEmpty()) {
            throw new IllegalStateException("To, Subject, and Body are required and cannot be empty.");
        }
        return new Email(this);
    }
}

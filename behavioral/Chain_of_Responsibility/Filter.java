// Abstract filter class (Handler in Chain of Responsibility).
// Each filter will decide whether to process the email or pass it along the chain.
public abstract class Filter {
    protected Filter next;

    // Sets the next filter in the chain
    public void setNext(Filter next) {
        this.next = next;
    }

    // Handles the email processing
    public abstract void handle(Email email);
}

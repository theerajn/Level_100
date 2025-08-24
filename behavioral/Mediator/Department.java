// Abstract Department: Common interface for all departments
public abstract class Department {
    protected LoanMediator mediator;

    public Department(LoanMediator mediator) {
        this.mediator = mediator;
    }

    // Each department defines its own loan processing logic
    public abstract void process(String applicantName, double amount);
}

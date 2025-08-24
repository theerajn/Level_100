public abstract class Department {
    protected LoanMediator mediator;

    public Department(LoanMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void process(String applicantName, double amount);
}

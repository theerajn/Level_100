// Concrete Department: Handles final loan approval or rejection
public class ApprovalDepartment extends Department {

    public ApprovalDepartment(LoanMediator mediator) {
        super(mediator);
    }

    @Override
    public void process(String applicantName, double amount) {
        System.out.println("Final approval for loan of " + amount + " to " + applicantName);
        System.out.println("Loan Approved!");
    }

    // Handles rejection logic
    public void reject(String reason) {
        System.out.println("Loan Rejected: " + reason);
    }
}

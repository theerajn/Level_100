public class ApprovalDepartment extends Department {

    public ApprovalDepartment(LoanMediator mediator) {
        super(mediator);
    }

    @Override
    public void process(String applicantName, double amount) {
        System.out.println("Final approval for loan of " + amount + " to " + applicantName);
        System.out.println("Loan Approved!");
    }

    public void reject(String reason) {
        System.out.println("Loan Rejected: " + reason);
    }
}

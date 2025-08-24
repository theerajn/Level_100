// Concrete Department: Handles credit score check
public class CreditDepartment extends Department {

    public CreditDepartment(LoanMediator mediator) {
        super(mediator);
    }

    @Override
    public void process(String applicantName, double amount) {
        System.out.println("Checking credit score for " + applicantName + "...");
        boolean creditOk = amount <= 500000; // Simple check (loans above 500k fail credit)
        mediator.notifyDepartment("Credit", creditOk);
    }
}

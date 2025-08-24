// Concrete Department: Handles fraud detection
public class FraudDepartment extends Department {

    public FraudDepartment(LoanMediator mediator) {
        super(mediator);
    }

    @Override
    public void process(String applicantName, double amount) {
        System.out.println("Running fraud checks for " + applicantName + "...");
        boolean noFraud = !applicantName.equalsIgnoreCase("fraudster"); // reject if applicant name is "fraudster"
        mediator.notifyDepartment("Fraud", noFraud);
    }
}

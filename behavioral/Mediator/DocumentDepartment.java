// Concrete Department: Handles document verification
public class DocumentDepartment extends Department {

    public DocumentDepartment(LoanMediator mediator) {
        super(mediator);
    }

    @Override
    public void process(String applicantName, double amount) {
        System.out.println("Verifying documents for " + applicantName + "...");
        boolean documentsOk = applicantName.length() >= 3; // Simple check: name must be >=3 chars
        mediator.notifyDepartment("Document", documentsOk);
    }
}

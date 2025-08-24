public class DocumentDepartment extends Department {

    public DocumentDepartment(LoanMediator mediator) {
        super(mediator);
    }

    @Override
    public void process(String applicantName, double amount) {
        System.out.println("Verifying documents for " + applicantName + "...");
        boolean documentsOk = applicantName.length() >= 3; // Simple check
        mediator.notifyDepartment("Document", documentsOk);
    }
}

public class LoanMediatorImpl implements LoanMediator {
    private CreditDepartment creditDept;
    private DocumentDepartment docDept;
    private FraudDepartment fraudDept;
    private ApprovalDepartment approvalDept;

    private boolean creditOk = false;
    private boolean docsOk = false;
    private boolean fraudOk = false;

    public void setDepartments(CreditDepartment creditDept, DocumentDepartment docDept,
                                FraudDepartment fraudDept, ApprovalDepartment approvalDept) {
        this.creditDept = creditDept;
        this.docDept = docDept;
        this.fraudDept = fraudDept;
        this.approvalDept = approvalDept;
    }

    @Override
    public void requestLoan(String applicantName, double amount) {
        System.out.println("\n--- Loan Request Started ---");
        creditDept.process(applicantName, amount);
        docDept.process(applicantName, amount);
        fraudDept.process(applicantName, amount);

        if (creditOk && docsOk && fraudOk) {
            approvalDept.process(applicantName, amount);
        } else {
            String reason = (!creditOk ? "Low credit score" : !docsOk ? "Invalid documents" : "Fraud detected");
            approvalDept.reject(reason);
        }
        System.out.println("--- Loan Request Completed ---\n");
    }

    @Override
    public void notifyDepartment(String department, boolean status) {
        switch (department) {
            case "Credit" -> creditOk = status;
            case "Document" -> docsOk = status;
            case "Fraud" -> fraudOk = status;
        }
    }
}

// Mediator interface: Defines communication between departments
public interface LoanMediator {
    void requestLoan(String applicantName, double amount);
    void notifyDepartment(String department, boolean status);
}

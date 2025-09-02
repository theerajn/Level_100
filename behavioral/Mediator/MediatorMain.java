import java.util.Scanner;

// Client class: Entry point of the loan processing system
public class MediatorMain {
    public static void main(String[] args) {
        LoanMediatorImpl mediator = new LoanMediatorImpl();

        // Creating departments and injecting into mediator
        CreditDepartment credit = new CreditDepartment(mediator);
        DocumentDepartment document = new DocumentDepartment(mediator);
        FraudDepartment fraud = new FraudDepartment(mediator);
        ApprovalDepartment approval = new ApprovalDepartment(mediator);

        mediator.setDepartments(credit, document, fraud, approval);

        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter applicant name (or type 'exit'): ");
                String name = sc.nextLine().trim();
                if (name.equalsIgnoreCase("exit")) break;

                // Validate name (non-empty, alphabets only)
                if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                    System.out.println("Invalid name. Only alphabets allowed.\n");
                    continue;
                }

                System.out.println("Enter loan amount: ");
                String amountStr = sc.nextLine().trim();

                // Validate numeric amount
                if (!amountStr.matches("\\d+(\\.\\d+)?")) {
                    System.out.println("Invalid amount. Enter a numeric value.\n");
                    continue;
                }
                double amount = Double.parseDouble(amountStr);

                // Request loan through mediator
                mediator.requestLoan(name, amount);

            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        sc.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoanMediatorImpl mediator = new LoanMediatorImpl();

        CreditDepartment credit = new CreditDepartment(mediator);
        DocumentDepartment document = new DocumentDepartment(mediator);
        FraudDepartment fraud = new FraudDepartment(mediator);
        ApprovalDepartment approval = new ApprovalDepartment(mediator);

        mediator.setDepartments(credit, document, fraud, approval);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter applicant name (or type 'exit'): ");
            String name = sc.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) break;

            if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Only alphabets allowed.\n");
                continue;
            }

            System.out.println("Enter loan amount: ");
            String amountStr = sc.nextLine().trim();
            if (!amountStr.matches("\\d+(\\.\\d+)?")) {
                System.out.println("Invalid amount. Enter a numeric value.\n");
                continue;
            }
            double amount = Double.parseDouble(amountStr);

            mediator.requestLoan(name, amount);
        }
        sc.close();
    }
}

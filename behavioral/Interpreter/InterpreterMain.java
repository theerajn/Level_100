import java.util.Scanner;

// Client: collects input, validates, and invokes the workflow engine
public class InterpreterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkflowEngine engine = new WorkflowEngine();

        System.out.println("=== Enterprise Workflow Automation ===");

        try {
            while (true) {
                String role = promptRole(scanner);
                if (role == null) break; // user chose to exit

                String action = promptAction(scanner);
                if (action == null) break; // user chose to exit

                try {
                    engine.executeWorkflow(role, action); // Execute workflow safely
                } catch (Exception e) {
                    System.out.println("Error executing workflow: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            System.out.println("Exiting...");
            scanner.close();
        }
    }

    // Validates role input
    private static String promptRole(Scanner scanner) {
        while (true) {
            try {
                System.out.print("\nEnter Role (Admin/Manager/User) or EXIT to quit: ");
                String role = scanner.nextLine().trim();

                if (role.equalsIgnoreCase("EXIT")) return null;

                if (role.equalsIgnoreCase("Admin") ||
                    role.equalsIgnoreCase("Manager") ||
                    role.equalsIgnoreCase("User")) {
                    return role;
                }
                System.out.println("Invalid role. Please enter Admin, Manager, or User.");
            } catch (Exception e) {
                System.out.println("Error reading role input: " + e.getMessage());
            }
        }
    }

    // Validates action input
    private static String promptAction(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter Action (Approve/Reject/Escalate) or EXIT to quit: ");
                String action = scanner.nextLine().trim();

                if (action.equalsIgnoreCase("EXIT")) return null;

                if (action.equalsIgnoreCase("Approve") ||
                    action.equalsIgnoreCase("Reject") ||
                    action.equalsIgnoreCase("Escalate")) {
                    return action;
                }
                System.out.println("Invalid action. Please enter Approve, Reject, or Escalate.");
            } catch (Exception e) {
                System.out.println("Error reading action input: " + e.getMessage());
            }
        }
    }
}

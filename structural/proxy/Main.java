import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your role (admin/user): ");
        String role = scanner.nextLine();

        DataAccess proxy = new DataAccessProxy(role);

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. View Data");
            System.out.println("2. Delete Data");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    proxy.viewData();
                    break;
                case 2:
                    proxy.deleteData();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

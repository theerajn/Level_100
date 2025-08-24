import java.util.Scanner;

// Client: provides menu-driven interaction with the ATM
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATMMachine atm = new ATMMachine();

        while (true) {
            System.out.println("\n--- ATM Machine ---");
            String[] options = atm.getCurrentState().getAvailableOptions();

            // Show available options dynamically based on state
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            if (choice < 1 || choice > options.length) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            String selected = options[choice - 1];

            switch (selected) {
                case "Insert Card":
                    atm.insertCard();
                    break;
                case "Eject Card":
                    atm.ejectCard();
                    break;
                case "Enter PIN":
                    System.out.print("Enter PIN: ");
                    if (sc.hasNextInt()) {
                        atm.enterPin(sc.nextInt());
                    } else {
                        System.out.println("Invalid PIN format.");
                        sc.next();
                    }
                    break;
                case "Request Cash":
                    System.out.print("Enter amount: ");
                    if (sc.hasNextInt()) {
                        atm.requestCash(sc.nextInt());
                    } else {
                        System.out.println("Invalid amount.");
                        sc.next();
                    }
                    break;
                case "Exit":
                    System.out.println("Thank you for using the ATM.");
                    sc.close();
                    return;
            }
        }
    }
}

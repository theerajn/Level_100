import java.util.Scanner;

// Client: Provides interface for user to choose and execute commands
public class Main {
    public static void main(String[] args) {
        JobInvoker invoker = new JobInvoker();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Job Scheduler ===");

        while (running) {
            System.out.println("\nSelect a job to schedule:");
            System.out.println("1. Print Job");
            System.out.println("2. Email Job");
            System.out.println("3. Backup Job");
            System.out.println("4. Shutdown Job");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    invoker.setCommand(new PrintJob()); // set PrintJob
                    break;
                case "2":
                    invoker.setCommand(new EmailJob()); // set EmailJob
                    break;
                case "3":
                    invoker.setCommand(new BackupJob()); // set BackupJob
                    break;
                case "4":
                    invoker.setCommand(new ShutdownJob()); // set ShutdownJob
                    break;
                case "5":
                    running = false;
                    System.out.println("Exiting Job Scheduler.");
                    continue;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    continue;
            }

            invoker.runCommand(); // execute the selected job
        }

        scanner.close();
    }
}

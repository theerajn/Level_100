// Client code: Interacts with TaskExecutor to perform tasks on various robots
import java.util.Scanner;

public class BridgeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Robot robot = null;

        try {
            while (true) {
                System.out.println("\nSelect Robot Model:");
                System.out.println("1. Kiva Robot");
                System.out.println("2. Fetch Robot");
                System.out.println("3. ABB Robot");
                System.out.println("4. Exit Program");
                System.out.print("Enter choice: ");
                String robotChoice = scanner.nextLine();

                TaskExecutor executor;
                switch (robotChoice) {
                    case "1":
                        robot = new KivaRobot();
                        executor = new TaskExecutor(robot);
                        break;
                    case "2":
                        robot = new FetchRobot();
                        executor = new TaskExecutor(robot);
                        break;
                    case "3":
                        robot = new ABBRobot();
                        executor = new TaskExecutor(robot);
                        break;
                    case "4":
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid robot choice.");
                        continue;
                }

                // Inner loop to handle robot tasks
                while (true) {
                    System.out.println("\nSelect Task to Execute for " + robot.getRobotName() + ":");
                    System.out.println("1. Pick");
                    System.out.println("2. Place");
                    System.out.println("3. Scan");
                    System.out.println("4. Charge");
                    System.out.println("5. Change Robot / Main Menu");
                    System.out.print("Enter task: ");
                    String taskChoice = scanner.nextLine();

                    switch (taskChoice) {
                        case "1":
                            executor.performPick();
                            break;
                        case "2":
                            executor.performPlace();
                            break;
                        case "3":
                            executor.performScan();
                            break;
                        case "4":
                            executor.performCharge();
                            break;
                        case "5":
                            System.out.println("Returning to main menu...");
                            break;
                        default:
                            System.out.println("Invalid task choice.");
                            continue;
                    }

                    if (taskChoice.equals("5")) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

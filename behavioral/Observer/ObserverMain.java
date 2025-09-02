import java.util.Scanner;

// Client class to simulate live sports score updates
public class ObserverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SportsScore sportsScore = new SportsScore();

        // Adding observers (Mobile App & Web App)
        sportsScore.addObserver(new MobileAppDisplay("Fan1"));
        sportsScore.addObserver(new WebAppDisplay("LiveScoreSite"));

        while (true) {
            try {
                System.out.println("\n--- Sports Score Update System ---");
                System.out.println("1. Update Score");
                System.out.println("2. Exit");
                System.out.print("Enter choice: ");

                String choice = scanner.nextLine().trim();

                if (choice.equals("1")) {
                    System.out.print("Enter Team Name: ");
                    String teamName = scanner.nextLine().trim();

                    if (teamName.isEmpty()) {
                        System.out.println("Team name cannot be empty.");
                        continue;
                    }

                    System.out.print("Enter Score (integer): ");
                    String scoreInput = scanner.nextLine().trim();

                    try {
                        int score = Integer.parseInt(scoreInput);
                        sportsScore.setScore(teamName, score); // update & notify observers
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid score. Please enter an integer.");
                    }

                } else if (choice.equals("2")) {
                    System.out.println("Exiting... ");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

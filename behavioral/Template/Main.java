import java.util.Scanner;

// Main driver program to run the Resume Screening system
// Provides interactive menu for different roles and validates inputs
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== AI-Powered Resume Screening (Template Method) ===");

        while (true) {
            // Menu-driven system for role selection
            System.out.println("\nMenu:");
            System.out.println("1. Screen a resume for Java Developer");
            System.out.println("2. Screen a resume for UX Designer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();
            if ("3".equals(choice)) {
                System.out.println("Exiting..");
                sc.close();
                return;
            }

            ResumeScreeningTemplate pipeline;
            // Select screening pipeline based on role
            if ("1".equals(choice)) pipeline = new JavaDeveloperScreening();
            else if ("2".equals(choice)) pipeline = new UXDesignerScreening();
            else {
                System.out.println("Invalid choice. Enter 1, 2, or 3.");
                continue;
            }

            // Input validation for applicant name
            String name;
            while (true) {
                System.out.print("Enter applicant full name: ");
                name = sc.nextLine().trim();
                if (name.isEmpty()) System.out.println("Name cannot be empty.");
                else break;
            }

            // Input validation for years of experience
            int years;
            while (true) {
                System.out.print("Enter years of experience: ");
                String yrs = sc.nextLine().trim();
                try {
                    years = Integer.parseInt(yrs);
                    if (years < 0) {
                        System.out.println("Years cannot be negative.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please enter an integer.");
                }
            }

            // Collect resume text until user types END
            System.out.println("Paste resume text (type a single line with only END to finish):");
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = sc.nextLine();
                if (line != null && line.trim().equalsIgnoreCase("END")) break;
                sb.append(line).append("\n");
            }
            String resumeText = sb.toString().trim();
            if (resumeText.isEmpty()) {
                System.out.println("Resume text cannot be empty. Aborting this run.");
                continue;
            }

            // Build resume object and process using selected pipeline
            Resume resume = new Resume(name, years, resumeText);
            ScreeningResult result = pipeline.processResume(resume);
            result.printReport();

            // Option to process more resumes
            System.out.print("Process another resume? (y/n): ");
            String again = sc.nextLine().trim();
            if (!again.equalsIgnoreCase("y")) {
                System.out.println("Exiting..!");
                sc.close();
                return;
            }
        }
    }
}

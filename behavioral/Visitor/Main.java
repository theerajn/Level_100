import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Healthcare Patient Report System ---");
            System.out.println("1. Add Inpatient");
            System.out.println("2. Add Outpatient");
            System.out.println("3. Add Emergency Case");
            System.out.println("4. Generate Medical History Report");
            System.out.println("5. Generate Billing Report");
            System.out.println("6. Generate Insurance Claim Report");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    // Add Inpatient details
                    System.out.print("Enter Name: ");
                    String inName = sc.nextLine();
                    int inAge = readInt(sc, "Enter Age: ");
                    int days = readInt(sc, "Enter Days Admitted: ");
                    double rate = readDouble(sc, "Enter Daily Rate: ");
                    patients.add(new Inpatient(inName, inAge, days, rate));
                    break;

                case "2":
                    // Add Outpatient details
                    System.out.print("Enter Name: ");
                    String outName = sc.nextLine();
                    int outAge = readInt(sc, "Enter Age: ");
                    System.out.print("Enter Consultation Type: ");
                    String type = sc.nextLine();
                    double fee = readDouble(sc, "Enter Consultation Fee: ");
                    patients.add(new Outpatient(outName, outAge, type, fee));
                    break;

                case "3":
                    // Add Emergency Case details
                    System.out.print("Enter Name: ");
                    String emName = sc.nextLine();
                    int emAge = readInt(sc, "Enter Age: ");
                    System.out.print("Enter Severity Level: ");
                    String severity = sc.nextLine();
                    double cost = readDouble(sc, "Enter Treatment Cost: ");
                    patients.add(new EmergencyCase(emName, emAge, severity, cost));
                    break;

                case "4":
                    // Generate Medical History Report
                    generateReport(patients, new MedicalHistoryReport());
                    break;

                case "5":
                    // Generate Billing Report
                    generateReport(patients, new BillingReport());
                    break;

                case "6":
                    // Generate Insurance Claim Report
                    generateReport(patients, new InsuranceClaimReport());
                    break;

                case "7":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Generic method to generate report using Visitor
    private static void generateReport(List<Patient> patients, PatientVisitor visitor) {
        if (patients.isEmpty()) {
            System.out.println("No patients to generate report!");
        } else {
            for (Patient p : patients) {
                p.accept(visitor); // Double dispatch
            }
        }
    }

    // Input validation for integers
    private static int readInt(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    // Input validation for doubles
    private static double readDouble(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please try again.");
            }
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailBuilder builder = new EmailBuilder();

        String to = InputHelper.getRequiredInput(scanner, "Enter To (required): ");
        builder.setTo(to);

        String subject = InputHelper.getRequiredInput(scanner, "Enter Subject (required): ");
        builder.setSubject(subject);

        String body = InputHelper.getRequiredInput(scanner, "Enter Body (required): ");
        builder.setBody(body);

        System.out.print("Enter CC (optional, press Enter to skip): ");
        String cc = scanner.nextLine();
        if (!cc.trim().isEmpty()) builder.setCc(cc);

        System.out.print("Enter BCC (optional, press Enter to skip): ");
        String bcc = scanner.nextLine();
        if (!bcc.trim().isEmpty()) builder.setBcc(bcc);

        System.out.print("Enter Attachment (optional, press Enter to skip): ");
        String attachment = scanner.nextLine();
        if (!attachment.trim().isEmpty()) builder.setAttachment(attachment);

        try {
            Email email = builder.build();
            System.out.println("\n" + email);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}

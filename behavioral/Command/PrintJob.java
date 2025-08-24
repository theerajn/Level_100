public class PrintJob  implements Command {
    @Override
    public void execute() {
        System.out.println("Executing Print Job: Printing document...");
    }
}

// Concrete Command: Represents an email job
public class EmailJob implements Command {
    @Override
    public void execute() {
        System.out.println("Executing email job...");
    }
}

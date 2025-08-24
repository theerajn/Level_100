// Concrete Command: Represents a shutdown job
public class ShutdownJob implements Command {
    @Override
    public void execute() {
        System.out.println("Executing shutdown job...");
    }
}

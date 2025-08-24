// Invoker: Stores and executes the command
public class JobInvoker {
    private Command command;

    // Set the command to be executed
    public void setCommand(Command command) {
        this.command = command;
    }

    // Execute the command if it's set
    public void runCommand() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command has been set.");
        }
    }
}

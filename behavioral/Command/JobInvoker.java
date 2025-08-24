public class JobInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void runCommand() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command has been set.");
        }
    }
}

public class BackupJob implements Command {
    @Override
    public void execute() {
        System.out.println("Executing Backup Job: Backing up files to the cloud...");
    }
}

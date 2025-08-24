// Facade: Provides simplified methods to perform tasks on robots without directly interacting with Robot implementations
public class TaskExecutor {
    private Robot robot;

    public TaskExecutor(Robot robot) {
        this.robot = robot;
    }

    public void performPick() {
        robot.pick();
    }

    public void performPlace() {
        robot.place();
    }

    public void performScan() {
        robot.scan();
    }

    public void performCharge() {
        robot.charge();
    }
}

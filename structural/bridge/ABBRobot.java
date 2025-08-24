// Concrete implementation of Robot interface
public class ABBRobot implements Robot {
    private boolean isCharging = false;

    @Override
    public void pick() {
        System.out.println("ABB robot picking an item.");
    }

    @Override
    public void place() {
        System.out.println("ABB robot placing an item.");
    }

    @Override
    public void scan() {
        System.out.println("ABB robot scanning an item.");
    }

    @Override
    public void charge() {
        if (isCharging) {
            System.out.println("ABB robot is already charging.");
        } else {
            System.out.println("ABB robot charging.");
            isCharging = true;
        }
    }

    @Override
    public String getRobotName() {
        return "ABB Robot";
    }
}

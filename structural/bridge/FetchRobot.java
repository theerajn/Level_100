// Concrete implementation of Robot interface
public class FetchRobot implements Robot {
    @Override
    public void pick() {
        System.out.println("Fetch robot picking an item.");
    }

    @Override
    public void place() {
        System.out.println("Fetch robot placing an item.");
    }

    @Override
    public void scan() {
        System.out.println("Fetch robot scanning an item.");
    }

    @Override
    public void charge() {
        System.out.println("Fetch robot charging.");
    }

    @Override
    public String getRobotName() {
        return "Fetch Robot";
    }
}

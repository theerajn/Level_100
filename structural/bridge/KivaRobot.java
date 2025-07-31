public class KivaRobot implements Robot {
    private boolean isCharging = false;

    @Override
    public void pick() {
        System.out.println("Kiva robot picking an item.");
    }

    @Override
    public void place() {
        System.out.println("Kiva robot placing an item.");
    }

    @Override
    public void scan() {
        System.out.println("Kiva robot scanning an item.");
    }

    @Override
    public void charge() {
        if (isCharging) {
            System.out.println("Kiva robot is already charging.");
        } else {
            System.out.println("Kiva robot charging.");
            isCharging = true;
        }
    }

    @Override
    public String getRobotName() {
        return "Kiva Robot";
    }
}

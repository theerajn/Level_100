// Adapter: Wraps SmartBulb to make it compatible with SmartDevice interface
public class SmartBulbAdapter implements SmartDevice {
    private SmartBulb bulb;
    private boolean isOn = false;

    public SmartBulbAdapter() {
        this.bulb = new SmartBulb();
    }

    @Override
    public void turnOn() {
        if (isOn) {
            System.out.println("Smart Bulb is already ON.");
        } else {
            bulb.enableLight();
            isOn = true;
        }
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Smart Bulb is already OFF.");
        } else {
            bulb.disableLight();
            isOn = false;
        }
    }

    @Override
    public String getDeviceName() {
        return "Smart Bulb";
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}

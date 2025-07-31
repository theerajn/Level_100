public class SmartPlugAdapter implements SmartDevice {
    private SmartPlug plug;
    private boolean isOn = false;

    public SmartPlugAdapter() {
        this.plug = new SmartPlug();
    }

    @Override
    public void turnOn() {
        if (isOn) {
            System.out.println("Smart Plug is already ON.");
        } else {
            plug.powerOn();
            isOn = true;
        }
    }

    @Override
    public void turnOff() {
        if (!isOn) {
            System.out.println("Smart Plug is already OFF.");
        } else {
            plug.powerOff();
            isOn = false;
        }
    }

    @Override
    public String getDeviceName() {
        return "Smart Plug";
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}

// Target interface: All smart devices implement this to provide a uniform interface
public interface SmartDevice {
    void turnOn();
    void turnOff();
    String getDeviceName();
    boolean isOn();
}

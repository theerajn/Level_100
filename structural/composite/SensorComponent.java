// Component interface - defines common operations for both leaf and composite
public interface SensorComponent {
    void status();
    void updateFirmware();
    void collectData();
}

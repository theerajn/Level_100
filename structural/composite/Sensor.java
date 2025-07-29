public class Sensor implements SensorComponent {
    private String id;
    private SensorType type;

    public enum SensorType {
        TEMPERATURE,
        HUMIDITY,
        SMOKE,
        PRESSURE
    }

    public Sensor(String id, SensorType type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public void status() {
        System.out.println("Sensor ID: " + id + ", Type: " + type + " -> Status: ACTIVE");
    }

    @Override
    public void updateFirmware() {
        System.out.println("Sensor ID: " + id + " -> Firmware updated.");
    }

    @Override
    public void collectData() {
        System.out.println("Sensor ID: " + id + ", Type: " + type + " -> Data: [Sample data collected]");
    }

    public String getId() {
        return id;
    }
}

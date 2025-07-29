import java.util.ArrayList;
import java.util.List;

public class SensorGroup implements SensorComponent {
    private String name;
    private List<SensorComponent> components = new ArrayList<>();

    public SensorGroup(String name) {
        this.name = name;
    }

    public void addComponent(SensorComponent component) {
        components.add(component);
    }

    @Override
    public void status() {
        System.out.println("Group: " + name + " -> Checking status of components:");
        for (SensorComponent component : components) {
            component.status();
        }
    }

    @Override
    public void updateFirmware() {
        System.out.println("Group: " + name + " -> Updating firmware for all components:");
        for (SensorComponent component : components) {
            component.updateFirmware();
        }
    }

    @Override
    public void collectData() {
        System.out.println("Group: " + name + " -> Collecting data from all components:");
        for (SensorComponent component : components) {
            component.collectData();
        }
    }

    public String getName() {
        return name;
    }
}

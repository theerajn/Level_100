import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
public class VehicleFactory {
    private static final Map<String, VehicleType> vehicleTypes = new HashMap<>();
    
    public static VehicleType getVehicleType(String type, String icon) {
        String key = type + "-" + icon;
        if (!vehicleTypes.containsKey(key)) {
            vehicleTypes.put(key, new VehicleType(type, icon));
        }
        return vehicleTypes.get(key);
    }

    public static int totalTypes() {
        return vehicleTypes.size();
    }
}
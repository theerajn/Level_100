import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
// Manages and reuses shared VehicleType objects
public class VehicleFactory {
    private static final Map<String, VehicleType> vehicleTypes = new HashMap<>();
    
    // Returns existing VehicleType if available; otherwise creates new
    public static VehicleType getVehicleType(String type, String icon) {
        String key = type + "-" + icon;
        if (!vehicleTypes.containsKey(key)) {
            vehicleTypes.put(key, new VehicleType(type, icon));
        }
        return vehicleTypes.get(key);
    }

    // Returns total unique VehicleType objects created
    public static int totalTypes() {
        return vehicleTypes.size();
    }
}

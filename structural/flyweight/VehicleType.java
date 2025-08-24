// Flyweight class
// Represents intrinsic (shared) state: type and icon of vehicle
public class VehicleType {
    private final String type;
    private final String icon;

    public VehicleType(String type, String icon) {
        this.type = type;
        this.icon = icon;
    }

    // Rendering uses shared intrinsic state + extrinsic state (position & direction)
    public void render(int x, int y, String direction) {
        System.out.println("Rendering " + type + " [" + icon + "] at (" + x + "," + y + ") heading " + direction);
    }
}

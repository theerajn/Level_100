// Flyweight class
public class VehicleType {
    private final String type;
    private final String icon;

    public VehicleType(String type, String icon) {
        this.type = type;
        this.icon = icon;
    }

    public void render(int x, int y, String direction) {
        System.out.println("Rendering " + type + " [" + icon + "] at (" + x + "," + y + ") heading " + direction);
    }
}

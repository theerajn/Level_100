// Extrinsic state holder (Context)
// Stores external details (coordinates, direction) for each vehicle
public class Vehicle {
    private final int x;
    private final int y;
    private final String direction;
    private final VehicleType type; // Shared flyweight object

    public Vehicle(int x, int y, String direction, VehicleType type) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.type = type;
    }

    // Delegates rendering to VehicleType (flyweight) with extrinsic data
    public void draw() {
        type.render(x, y, direction);
    }
}

// Extrinsic state holder (Context)
public class Vehicle {
    private final int x;
    private final int y;
    private final String direction;
    private final VehicleType type;

    public Vehicle(int x, int y, String direction, VehicleType type) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.type = type;
    }

    public void draw() {
        type.render(x, y, direction);
    }
}

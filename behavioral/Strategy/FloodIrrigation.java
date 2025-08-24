
public class FloodIrrigation implements IrrigationStrategy {
    @Override
    public void irrigate(double areaSize, double waterLevel) {
        System.out.println("Flood Irrigation selected.");
        double waterNeeded = areaSize * 10; // liters per m²
        if (waterLevel >= waterNeeded) {
            System.out.println("Field is flooded with water.");
        } else {
            System.out.println("Not enough water in tank for flood irrigation.");
        }
    }
}

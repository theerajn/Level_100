
public class SprinklerIrrigation implements IrrigationStrategy {
    @Override
    public void irrigate(double areaSize, double waterLevel) {
        System.out.println("Sprinkler Irrigation selected.");
        double waterNeeded = areaSize * 5; // liters per m²
        if (waterLevel >= waterNeeded) {
            System.out.println("Water is being sprayed evenly over the field.");
        } else {
            System.out.println("Not enough water in tank for sprinkler irrigation.");
        }
    }
}

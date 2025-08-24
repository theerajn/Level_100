
public class DripIrrigation implements IrrigationStrategy {
    @Override
    public void irrigate(double areaSize, double waterLevel) {
        System.out.println("Drip Irrigation selected.");
        double waterNeeded = areaSize * 2; // liters per m²
        if (waterLevel >= waterNeeded) {
            System.out.println("Supplying water efficiently to roots using drip lines.");
        } else {
            System.out.println("Not enough water in tank for drip irrigation.");
        }
    }
}

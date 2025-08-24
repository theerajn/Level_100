// Concrete Strategy: Drip irrigation method
public class DripIrrigation implements IrrigationStrategy {
    @Override
    public void irrigate(int fieldArea, int availableWater) {
        // Water requirement = 2 liters per m²
        int requiredWater = fieldArea * 2;
        if (availableWater >= requiredWater) {
            System.out.println("Drip Irrigation selected.");
            System.out.println("Supplying water efficiently to roots using drip lines.");
        } else {
            System.out.println("Not enough water in tank for drip irrigation.");
        }
    }
}

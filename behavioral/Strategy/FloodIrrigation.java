// Concrete Strategy: Flood irrigation method
public class FloodIrrigation implements IrrigationStrategy {
    @Override
    public void irrigate(int fieldArea, int availableWater) {
        // Water requirement = 10 liters per m²
        int requiredWater = fieldArea * 10;
        if (availableWater >= requiredWater) {
            System.out.println("Flood Irrigation selected.");
            System.out.println("Flooding the entire field with water.");
        } else {
            System.out.println("Not enough water in tank for flood irrigation.");
        }
    }
}

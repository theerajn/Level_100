// Concrete Strategy: Sprinkler irrigation method
public class SprinklerIrrigation implements IrrigationStrategy {
    @Override
    public void irrigate(int fieldArea, int availableWater) {
        // Water requirement = 5 liters per m²
        int requiredWater = fieldArea * 5;
        if (availableWater >= requiredWater) {
            System.out.println("Sprinkler Irrigation selected.");
            System.out.println("Spraying water evenly using sprinklers.");
        } else {
            System.out.println("Not enough water in tank for sprinkler irrigation.");
        }
    }
}

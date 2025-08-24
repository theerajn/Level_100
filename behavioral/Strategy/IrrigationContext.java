// Context class: Maintains a reference to an irrigation strategy
public class IrrigationContext {
    private IrrigationStrategy strategy;

    // Set irrigation strategy dynamically
    public void setStrategy(IrrigationStrategy strategy) {
        this.strategy = strategy;
    }

    // Execute selected strategy
    public void executeStrategy(int fieldArea, int availableWater) {
        if (strategy != null) {
            strategy.irrigate(fieldArea, availableWater);
        } else {
            System.out.println("No irrigation strategy selected.");
        }
    }
}

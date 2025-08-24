
public class IrrigationContext {
    private IrrigationStrategy strategy;

    public void setStrategy(IrrigationStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeIrrigation(double areaSize, double waterLevel) {
        if (strategy == null) {
            System.out.println("No irrigation strategy selected.");
        } else {
            strategy.irrigate(areaSize, waterLevel);
        }
    }
}

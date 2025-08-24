// Concrete Decorator - removes special characters
public class SpecialCharRemovalDecorator extends ETLDecorator {
    public SpecialCharRemovalDecorator(ETLComponent component) {
        super(component);
    }

    @Override
    public String process() {
        return super.process().replaceAll("[^a-zA-Z0-9\\s]", "");
    }
}

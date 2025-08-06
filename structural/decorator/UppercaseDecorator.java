public class UppercaseDecorator extends ETLDecorator {
    public UppercaseDecorator(ETLComponent component) {
        super(component);
    }

    @Override
    public String process() {
        return super.process().toUpperCase();
    }
}

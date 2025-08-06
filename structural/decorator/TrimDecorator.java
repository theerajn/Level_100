public class TrimDecorator extends ETLDecorator {
    public TrimDecorator(ETLComponent component) {
        super(component);
    }

    @Override
    public String process() {
        return super.process().trim();
    }
}

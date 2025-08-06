public abstract class ETLDecorator implements ETLComponent {
    protected ETLComponent component;

    public ETLDecorator(ETLComponent component) {
        this.component = component;
    }

    @Override
    public String process() {
        return component.process();
    }
}

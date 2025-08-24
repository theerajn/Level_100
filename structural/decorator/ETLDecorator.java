// Abstract Decorator - wraps an ETLComponent
public abstract class ETLDecorator implements ETLComponent {
    protected ETLComponent component;

    public ETLDecorator(ETLComponent component) {
        this.component = component;
    }

    @Override
    public String process() {
        // Delegates call to the wrapped component
        return component.process();
    }
}

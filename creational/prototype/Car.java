// Concrete class implementing Prototype pattern
public class Car implements CarPrototype {
    private String model;
    private String engine;
    private String color;
    private boolean sunroof;
    private boolean gps;

    public Car(String model, String engine, String color, boolean sunroof, boolean gps) {
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.sunroof = sunroof;
        this.gps = gps;
    }

    // Clone method to duplicate Car objects
    public Car cloneCar() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    public String getColor() {
        return color;
    }

    public boolean hasSunroof() {
        return sunroof;
    }

    @Override
    public String toString() {
        return "Car [model=" + model +
               ", engine=" + engine +
               ", color=" + color +
               ", sunroof=" + sunroof +
               ", gps=" + gps + "]";
    }
}

// Refined Abstraction
public class Truck extends Vehicle {
    public Truck(Engine engine) {
        super(engine);
    }

    void drive() {
        System.out.println("Truck is being driven.");
    }
}

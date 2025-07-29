// Refined Abstraction
public class Car extends Vehicle {
    public Car(Engine engine) {
        super(engine);
    }

    void drive() {
        System.out.println("Car is being driven.");
    }
}

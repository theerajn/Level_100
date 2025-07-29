public abstract class Vehicle {
    protected Engine engine;

    protected Vehicle(Engine engine) {
        this.engine = engine;
    }

    abstract void drive();

    void startEngine() {
        engine.start();
    }

    void stopEngine() {
        engine.stop();
    }
}

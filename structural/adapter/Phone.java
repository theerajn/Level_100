public class Phone {
    public void charge(USBTypeC charger) {
        System.out.println("Phone connecting to USB Type-C charger...");
        charger.connectTypeC();
        System.out.println("Charging started successfully!");
    }
}
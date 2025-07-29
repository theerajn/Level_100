public class MicroUSBtoTypeCAdapter implements USBTypeC {
    private MicroUSBCharger microUSBCharger;

    public MicroUSBtoTypeCAdapter(MicroUSBCharger charger) {
        this.microUSBCharger = charger;
    }

    @Override
    public void connectTypeC() {
        System.out.println("Using MicroUSB to Type-C adapter...");
        microUSBCharger.connectMicroUSB();
    }
}
public class OutOfCashState implements ATMState {
    ATMMachine atmMachine;

    public OutOfCashState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Machine is out of cash.");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Machine is out of cash.");
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Machine is out of cash.");
    }

    @Override
    public String[] getAvailableOptions() {
        return new String[]{"Exit"};
    }
}

// Concrete State: No card inserted
public class NoCardState implements ATMState {
    ATMMachine atmMachine;

    public NoCardState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card inserted. Please enter your PIN.");
        atmMachine.setATMState(atmMachine.getHasCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public String[] getAvailableOptions() {
        return new String[]{"Insert Card", "Exit"};
    }
}

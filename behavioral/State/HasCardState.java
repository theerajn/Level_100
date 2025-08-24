// Concrete State: Card inserted but no PIN entered
public class HasCardState implements ATMState {
    ATMMachine atmMachine;

    public HasCardState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atmMachine.setATMState(atmMachine.getNoCardState());
    }

    @Override
    public void enterPin(int pin) {
        if (pin == atmMachine.getCorrectPin()) {
            System.out.println("Correct PIN.");
            atmMachine.setATMState(atmMachine.getCorrectPinState());
        } else {
            System.out.println("Incorrect PIN. Card ejected.");
            atmMachine.setATMState(atmMachine.getNoCardState());
        }
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Enter PIN first.");
    }

    @Override
    public String[] getAvailableOptions() {
        return new String[]{"Eject Card", "Enter PIN", "Exit"};
    }
}

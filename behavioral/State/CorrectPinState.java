// Concrete State: Correct PIN entered
public class CorrectPinState implements ATMState {
    ATMMachine atmMachine;

    public CorrectPinState(ATMMachine atmMachine) {
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
        System.out.println("PIN already entered.");
    }

    @Override
    public void requestCash(int amount) {
        if (amount > atmMachine.getCashInMachine()) {
            System.out.println("Not enough cash available.");
            System.out.println("Card ejected.");
            atmMachine.setATMState(atmMachine.getNoCardState());
        } else {
            System.out.println("Dispensing " + amount + ".");
            atmMachine.setCashInMachine(atmMachine.getCashInMachine() - amount);

            if (atmMachine.getCashInMachine() <= 0) {
                System.out.println("ATM is now out of cash.");
                atmMachine.setATMState(atmMachine.getOutOfCashState());
            } else {
                System.out.println("Card ejected.");
                atmMachine.setATMState(atmMachine.getNoCardState());
            }
        }
    }

    @Override
    public String[] getAvailableOptions() {
        return new String[]{"Request Cash", "Eject Card", "Exit"};
    }
}

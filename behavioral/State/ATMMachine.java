// Context class: ATMMachine maintains current state and delegates behavior
public class ATMMachine {
    ATMState noCardState;
    ATMState hasCardState;
    ATMState correctPinState;
    ATMState outOfCashState;

    ATMState currentState;
    int cashInMachine = 5000; // Available cash in ATM
    final int correctPin = 1234; // Hardcoded correct PIN

    public ATMMachine() {
        // Initializing all possible states
        noCardState = new NoCardState(this);
        hasCardState = new HasCardState(this);
        correctPinState = new CorrectPinState(this);
        outOfCashState = new OutOfCashState(this);

        // Initial state = no card inserted
        currentState = noCardState;

        // If no cash available, move to OutOfCash state
        if (cashInMachine <= 0) {
            currentState = outOfCashState;
        }
    }

    // Getters & Setters
    public int getCashInMachine() { return cashInMachine; }
    public void setCashInMachine(int cash) { this.cashInMachine = cash; }
    public int getCorrectPin() { return correctPin; }
    public void setATMState(ATMState newState) { currentState = newState; }

    public ATMState getNoCardState() { return noCardState; }
    public ATMState getHasCardState() { return hasCardState; }
    public ATMState getCorrectPinState() { return correctPinState; }
    public ATMState getOutOfCashState() { return outOfCashState; }
    public ATMState getCurrentState() { return currentState; }

    // Delegate operations to current state
    public void insertCard() { currentState.insertCard(); }
    public void ejectCard() { currentState.ejectCard(); }
    public void enterPin(int pin) { currentState.enterPin(pin); }
    public void requestCash(int amount) { currentState.requestCash(amount); }
}

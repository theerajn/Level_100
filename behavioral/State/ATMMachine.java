public class ATMMachine {
    ATMState noCardState;
    ATMState hasCardState;
    ATMState correctPinState;
    ATMState outOfCashState;

    ATMState currentState;
    int cashInMachine = 5000; // Available cash
    final int correctPin = 1234; // Correct PIN

    public ATMMachine() {
        noCardState = new NoCardState(this);
        hasCardState = new HasCardState(this);
        correctPinState = new CorrectPinState(this);
        outOfCashState = new OutOfCashState(this);

        currentState = noCardState;
        if (cashInMachine <= 0) {
            currentState = outOfCashState;
        }
    }

    // Getter methods...
    public int getCashInMachine() {
        return cashInMachine;
    }

    public void setCashInMachine(int cash) {
        this.cashInMachine = cash;
    }

    public int getCorrectPin() {
        return correctPin;
    }

    public void setATMState(ATMState newState) {
        currentState = newState;
    }

    public ATMState getNoCardState() { return noCardState; }
    public ATMState getHasCardState() { return hasCardState; }
    public ATMState getCorrectPinState() { return correctPinState; }
    public ATMState getOutOfCashState() { return outOfCashState; }

    // Delegated methods
    public void insertCard() { currentState.insertCard(); }
    public void ejectCard() { currentState.ejectCard(); }
    public void enterPin(int pin) { currentState.enterPin(pin); }
    public void requestCash(int amount) { currentState.requestCash(amount); }

    public ATMState getCurrentState() { return currentState; }
}

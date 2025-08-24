// State interface: declares possible ATM actions
public interface ATMState {
    void insertCard();
    void ejectCard();
    void enterPin(int pin);
    void requestCash(int amount);
    String[] getAvailableOptions();  // Helps menu system
}

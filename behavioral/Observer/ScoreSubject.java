import java.util.ArrayList;
import java.util.List;

// Subject class: maintains observers and notifies them on updates
public class ScoreSubject {
    private List<Observer> observers = new ArrayList<>();

    // Add an observer
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove an observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers with updated score
    public void notifyObservers(String teamName, int score) {
        for (Observer observer : observers) {
            observer.update(teamName, score);
        }
    }
}

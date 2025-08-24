import java.util.ArrayList;
import java.util.List;

public class ScoreSubject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String teamName, int score) {
        for (Observer observer : observers) {
            observer.update(teamName, score);
        }
    }
}

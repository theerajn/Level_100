// Concrete Observer: Displays score updates on a mobile app
public class MobileAppDisplay implements Observer {
    private String displayName;

    public MobileAppDisplay(String name) {
        this.displayName = name;
    }

    @Override
    public void update(String teamName, int score) {
        System.out.println("[Mobile App - " + displayName + "] Score Update: " + teamName + " : " + score);
    }
}

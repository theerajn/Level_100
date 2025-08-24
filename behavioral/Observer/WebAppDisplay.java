// Concrete Observer: Displays score updates on a web app
public class WebAppDisplay implements Observer {
    private String displayName;

    public WebAppDisplay(String name) {
        this.displayName = name;
    }

    @Override
    public void update(String teamName, int score) {
        System.out.println("[Web App - " + displayName + "] Score Update: " + teamName + " : " + score);
    }
}

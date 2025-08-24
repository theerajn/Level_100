public class SportsScore extends ScoreSubject {
    private String teamName;
    private int score;

    public void setScore(String teamName, int score) {
        this.teamName = teamName;
        this.score = score;
        notifyObservers(teamName, score);
    }
}

import java.util.List;

public class ScreeningResult {
    private final String applicantName;
    private final String role;
    private final int score;
    private final boolean shortlisted;
    private final List<String> matchedSkills;
    private final String notes;

    public ScreeningResult(String applicantName, String role, int score,
                           boolean shortlisted, List<String> matchedSkills, String notes) {
        this.applicantName = applicantName;
        this.role = role;
        this.score = score;
        this.shortlisted = shortlisted;
        this.matchedSkills = matchedSkills;
        this.notes = notes;
    }

    public String getApplicantName() { return applicantName; }
    public String getRole() { return role; }
    public int getScore() { return score; }
    public boolean isShortlisted() { return shortlisted; }
    public List<String> getMatchedSkills() { return matchedSkills; }
    public String getNotes() { return notes; }

    public void printReport() {
        System.out.println("\n===== Screening Report =====");
        System.out.println("Applicant: " + applicantName);
        System.out.println("Role: " + role);
        System.out.println("Score: " + score);
        System.out.println("Shortlisted: " + (shortlisted ? "YES" : "NO"));
        System.out.println("Matched Skills: " + (matchedSkills.isEmpty() ? "None" : String.join(", ", matchedSkills)));
        System.out.println("Notes: " + notes);
        System.out.println("============================\n");
    }
}
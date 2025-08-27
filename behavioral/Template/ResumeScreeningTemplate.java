import java.util.List;

// Abstract class implementing Template Method Pattern
// Defines algorithm steps for screening while letting subclasses implement role-specific parts
public abstract class ResumeScreeningTemplate {
    protected Resume resume;
    protected List<String> matchedSkills;
    protected int score;
    protected String notes;

    // Template method: defines fixed steps of the algorithm
    public final ScreeningResult processResume(Resume resume) {
        this.resume = resume;
        this.matchedSkills = parseResumeForSkills(); // Role-specific parsing
        this.score = evaluateScore();                // Common scoring logic
        this.notes = prepareNotes();                 // Generate notes
        ScreeningResult result = new ScreeningResult(
                resume.getApplicantName(),
                getRoleName(),
                score,
                isShortlisted(score),
                matchedSkills,
                notes
        );
        storeResult(result); // Optional logging/storage
        return result;
    }

    // Abstract steps to be customized by each role
    protected abstract String getRoleName();
    protected abstract List<String> parseResumeForSkills();

    // Common scoring logic used by all subclasses
    protected int evaluateScore() {
        int skillPoints = matchedSkills.size() * getPointsPerSkill();
        int expPoints = Math.min(resume.getYearsOfExperience(), getExperienceCap()) * getPointsPerYear();
        return skillPoints + expPoints;
    }

    // Prepares human-readable notes for the screening result
    protected String prepareNotes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Experience: ").append(resume.getYearsOfExperience()).append(" years. ");
        sb.append("Matched ").append(matchedSkills.size()).append(" skill(s). ");
        if (score < getShortlistThreshold()) {
            sb.append("Recommendation: Do not shortlist.");
        } else {
            sb.append("Recommendation: Consider for next round.");
        }
        return sb.toString();
    }

    // Store or log results (hook method)
    protected void storeResult(ScreeningResult result) {
        System.out.printf("Processed %s for %s  Score: %d  Shortlisted: %s%n",
                result.getApplicantName(), result.getRole(), result.getScore(),
                result.isShortlisted() ? "YES" : "NO");
    }

    // Checks whether the score meets the threshold
    protected boolean isShortlisted(int score) {
        return score >= getShortlistThreshold();
    }

    // Default configuration hooks (can be overridden by subclasses)
    protected int getPointsPerSkill() { return 10; }
    protected int getPointsPerYear() { return 2; }
    protected int getExperienceCap() { return 10; }
    protected int getShortlistThreshold() { return 60; }
}

import java.util.List;

public abstract class ResumeScreeningTemplate {
    protected Resume resume;
    protected List<String> matchedSkills;
    protected int score;
    protected String notes;

    // Template method
    public final ScreeningResult processResume(Resume resume) {
        this.resume = resume;
        this.matchedSkills = parseResumeForSkills();
        this.score = evaluateScore();
        this.notes = prepareNotes();
        ScreeningResult result = new ScreeningResult(
                resume.getApplicantName(),
                getRoleName(),
                score,
                isShortlisted(score),
                matchedSkills,
                notes
        );
        storeResult(result);
        return result;
    }

    // steps (some concrete, some abstract)
    protected abstract String getRoleName();

    protected abstract List<String> parseResumeForSkills();

    protected int evaluateScore() {
        int skillPoints = matchedSkills.size() * getPointsPerSkill();
        int expPoints = Math.min(resume.getYearsOfExperience(), getExperienceCap()) * getPointsPerYear();
        return skillPoints + expPoints;
    }

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

    protected void storeResult(ScreeningResult result) {
        System.out.printf("Processed %s for %s — Score: %d — Shortlisted: %s%n",
                result.getApplicantName(), result.getRole(), result.getScore(),
                result.isShortlisted() ? "YES" : "NO");
    }

    protected boolean isShortlisted(int score) {
        return score >= getShortlistThreshold();
    }

    // configuration hooks with defaults
    protected int getPointsPerSkill() { return 10; }
    protected int getPointsPerYear() { return 2; }
    protected int getExperienceCap() { return 10; }
    protected int getShortlistThreshold() { return 60; }
}

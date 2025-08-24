import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

// Concrete implementation of ResumeScreeningTemplate for Java Developer role
// Defines keywords, scoring system, and threshold specific to Java Developers
public class JavaDeveloperScreening extends ResumeScreeningTemplate {
    // List of relevant keywords for Java Developer resumes
    private static final List<String> KEYWORDS = Arrays.asList(
            "java", "spring", "hibernate", "jpa", "microservices",
            "rest", "sql", "postgresql", "mysql", "docker", "kubernetes",
            "aws", "maven", "gradle", "git", "jenkins"
    );

    @Override
    protected String getRoleName() { return "Java Developer"; }

    // Parse resume text for presence of predefined Java keywords
    @Override
    protected List<String> parseResumeForSkills() {
        List<String> matches = new ArrayList<>();
        String text = resume.getResumeText().toLowerCase();
        for (String kw : KEYWORDS) {
            if (text.contains(kw)) {
                matches.add(kw);
            }
        }
        return matches;
    }

    // Slightly higher points per skill for technical depth
    @Override
    protected int getPointsPerSkill() { return 12; }

    // Higher threshold compared to default, ensuring stronger candidates
    @Override
    protected int getShortlistThreshold() { return 65; }
}

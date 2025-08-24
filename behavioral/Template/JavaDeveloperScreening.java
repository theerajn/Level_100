import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class JavaDeveloperScreening extends ResumeScreeningTemplate {
    private static final List<String> KEYWORDS = Arrays.asList(
            "java", "spring", "hibernate", "jpa", "microservices",
            "rest", "sql", "postgresql", "mysql", "docker", "kubernetes",
            "aws", "maven", "gradle", "git", "jenkins"
    );

    @Override
    protected String getRoleName() { return "Java Developer"; }

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

    @Override
    protected int getPointsPerSkill() { return 12; }

    @Override
    protected int getShortlistThreshold() { return 65; } // slightly higher threshold
}

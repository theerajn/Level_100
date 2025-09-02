import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Concrete implementation of ResumeScreeningTemplate for UX Designer role
// Defines keywords, scoring system, and threshold specific to UX Designers
public class UXDesignerScreening extends ResumeScreeningTemplate {
    // List of relevant keywords for UX Designer resumes
    private static final List<String> KEYWORDS = Arrays.asList(
            "figma", "sketch", "adobe xd", "wireframe", "prototyping",
            "usability", "ux research", "accessibility", "interaction design",
            "user research", "persona", "heuristic", "axure", "invision"
    );

    @Override
    protected String getRoleName() { return "UX Designer"; }

    // Parse resume text for presence of predefined UX keywords
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
    protected int getPointsPerSkill() { return 15; }

    @Override
    protected int getShortlistThreshold() { return 60; }
}

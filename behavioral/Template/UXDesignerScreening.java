import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class UXDesignerScreening extends ResumeScreeningTemplate {
    private static final List<String> KEYWORDS = Arrays.asList(
            "figma", "sketch", "adobe xd", "wireframe", "prototyping",
            "usability", "ux research", "accessibility", "interaction design",
            "user research", "persona", "heuristic", "axure", "invision"
    );

    @Override
    protected String getRoleName() { return "UX Designer"; }

    @Override
    protected List<String> parseResumeForSkills() {
        List<String> matches = new ArrayList<>();
        String text = resume.getResumeText().toLowerCase(Locale.ROOT);
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

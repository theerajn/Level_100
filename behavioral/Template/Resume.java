
public class Resume {
    private final String applicantName;
    private final int yearsOfExperience;
    private final String resumeText;

    public Resume(String applicantName, int yearsOfExperience, String resumeText) {
        this.applicantName = applicantName;
        this.yearsOfExperience = yearsOfExperience;
        this.resumeText = resumeText;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getResumeText() {
        return resumeText;
    }
}

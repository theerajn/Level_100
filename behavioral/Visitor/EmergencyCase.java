public class EmergencyCase implements Patient {
    private String name;
    private int age;
    private String severityLevel;
    private double treatmentCost;

    public EmergencyCase(String name, int age, String severityLevel, double treatmentCost) {
        this.name = name;
        this.age = age;
        this.severityLevel = severityLevel;
        this.treatmentCost = treatmentCost;
    }

    public String getSeverityLevel() { return severityLevel; }
    public double getTreatmentCost() { return treatmentCost; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public void accept(PatientVisitor visitor) {
        visitor.visit(this);
    }
}

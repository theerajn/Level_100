public class Outpatient implements Patient {
    private String name;
    private int age;
    private String consultationType;
    private double consultationFee;

    public Outpatient(String name, int age, String consultationType, double consultationFee) {
        this.name = name;
        this.age = age;
        this.consultationType = consultationType;
        this.consultationFee = consultationFee;
    }

    public String getConsultationType() { return consultationType; }
    public double getConsultationFee() { return consultationFee; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public void accept(PatientVisitor visitor) {
        visitor.visit(this);
    }
}

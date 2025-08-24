// Concrete Patient (Element) representing an inpatient
public class Inpatient implements Patient {
    private String name;
    private int age;
    private int daysAdmitted;
    private double dailyRate;

    public Inpatient(String name, int age, int daysAdmitted, double dailyRate) {
        this.name = name;
        this.age = age;
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    public int getDaysAdmitted() { return daysAdmitted; }
    public double getDailyRate() { return dailyRate; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public void accept(PatientVisitor visitor) {
        // Delegates operation to Visitor
        visitor.visit(this);
    }
}

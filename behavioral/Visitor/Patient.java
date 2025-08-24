// Element interface for Visitor pattern
public interface Patient {
    void accept(PatientVisitor visitor); // Accepts a Visitor
    String getName();
    int getAge();
}

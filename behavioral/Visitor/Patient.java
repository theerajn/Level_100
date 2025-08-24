public interface Patient {
    void accept(PatientVisitor visitor);
    String getName();
    int getAge();
}

// Visitor interface - defines operations for all concrete Patient types
public interface PatientVisitor {
    void visit(Inpatient inpatient);
    void visit(Outpatient outpatient);
    void visit(EmergencyCase emergencyCase);
}

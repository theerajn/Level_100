// Concrete Visitor that generates medical history report
public class MedicalHistoryReport implements PatientVisitor {
    @Override
    public void visit(Inpatient inpatient) {
        System.out.println("Medical History [Inpatient]: " + inpatient.getName() +
                ", Age: " + inpatient.getAge() +
                ", Days Admitted: " + inpatient.getDaysAdmitted());
    }

    @Override
    public void visit(Outpatient outpatient) {
        System.out.println("Medical History [Outpatient]: " + outpatient.getName() +
                ", Age: " + outpatient.getAge() +
                ", Consultation Type: " + outpatient.getConsultationType());
    }

    @Override
    public void visit(EmergencyCase emergencyCase) {
        System.out.println("Medical History [Emergency]: " + emergencyCase.getName() +
                ", Age: " + emergencyCase.getAge() +
                ", Severity: " + emergencyCase.getSeverityLevel());
    }
}

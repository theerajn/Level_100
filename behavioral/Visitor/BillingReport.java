// Concrete Visitor that handles billing logic for each type of Patient
public class BillingReport implements PatientVisitor {
    @Override
    public void visit(Inpatient inpatient) {
        // Billing based on days admitted * daily rate
        double totalBill = inpatient.getDaysAdmitted() * inpatient.getDailyRate();
        System.out.println("Billing [Inpatient]: " + inpatient.getName() +
                ", Total Bill: $" + totalBill);
    }

    @Override
    public void visit(Outpatient outpatient) {
        // Billing for outpatient is simply consultation fee
        System.out.println("Billing [Outpatient]: " + outpatient.getName() +
                ", Total Bill: $" + outpatient.getConsultationFee());
    }

    @Override
    public void visit(EmergencyCase emergencyCase) {
        // Billing for emergency based on treatment cost
        System.out.println("Billing [Emergency]: " + emergencyCase.getName() +
                ", Total Bill: $" + emergencyCase.getTreatmentCost());
    }
}

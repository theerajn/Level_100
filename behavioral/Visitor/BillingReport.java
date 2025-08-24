public class BillingReport implements PatientVisitor {
    @Override
    public void visit(Inpatient inpatient) {
        double totalBill = inpatient.getDaysAdmitted() * inpatient.getDailyRate();
        System.out.println("Billing [Inpatient]: " + inpatient.getName() +
                ", Total Bill: $" + totalBill);
    }

    @Override
    public void visit(Outpatient outpatient) {
        System.out.println("Billing [Outpatient]: " + outpatient.getName() +
                ", Total Bill: $" + outpatient.getConsultationFee());
    }

    @Override
    public void visit(EmergencyCase emergencyCase) {
        System.out.println("Billing [Emergency]: " + emergencyCase.getName() +
                ", Total Bill: $" + emergencyCase.getTreatmentCost());
    }
}

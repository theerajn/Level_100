public class InsuranceClaimReport implements PatientVisitor {
    @Override
    public void visit(Inpatient inpatient) {
        System.out.println("Insurance Claim [Inpatient]: " + inpatient.getName() +
                " - Eligible: YES");
    }

    @Override
    public void visit(Outpatient outpatient) {
        System.out.println("Insurance Claim [Outpatient]: " + outpatient.getName() +
                " - Eligible: LIMITED");
    }

    @Override
    public void visit(EmergencyCase emergencyCase) {
        System.out.println("Insurance Claim [Emergency]: " + emergencyCase.getName() +
                " - Eligible: FULL");
    }
}

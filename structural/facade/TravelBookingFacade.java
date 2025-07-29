public class TravelBookingFacade {
    private FlightBooking flightBooking;
    private HotelBooking hotelBooking;
    private CarRental carRental;
    private TravelInsurance travelInsurance;

    public TravelBookingFacade() {
        flightBooking = new FlightBooking();
        hotelBooking = new HotelBooking();
        carRental = new CarRental();
        travelInsurance = new TravelInsurance();
    }

    public void bookCompleteTravel(String from, String to, String hotelName, int nights,
                                   String carType, int days, String insurancePlan) {
        System.out.println("\nStarting complete travel booking...");
        flightBooking.bookFlight(from, to);
        hotelBooking.bookHotel(hotelName, nights);
        carRental.rentCar(carType, days);
        travelInsurance.buyInsurance(insurancePlan);
        System.out.println("Travel booking completed successfully!");
    }
}

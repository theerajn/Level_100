import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Travel Booking System");

        System.out.print("Enter flight origin city: ");
        String from = scanner.nextLine();

        System.out.print("Enter flight destination city: ");
        String to = scanner.nextLine();

        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();

        System.out.print("Enter number of hotel nights: ");
        int nights = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter car type for rental: ");
        String carType = scanner.nextLine();

        System.out.print("Enter number of car rental days: ");
        int days = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter travel insurance plan: ");
        String insurancePlan = scanner.nextLine();

        TravelBookingFacade travelFacade = new TravelBookingFacade();
        travelFacade.bookCompleteTravel(from, to, hotelName, nights, carType, days, insurancePlan);

        scanner.close();
    }
}

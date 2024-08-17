import model.*;
import service.ConcertBookingService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConcertBookingDemo {
    public static synchronized  void run(){
        ConcertBookingService concertBookingService = ConcertBookingService.getConcertBookingService();

        List<Seat> concert1Seats = generateSeats(100);
        Concert concert1 = new Concert("C001", "Artist 1", "Venue 1", "25-09-2024", concert1Seats);
        concertBookingService.addConcert(concert1);

        List<Seat> concert2Seats =  generateSeats(50);
        Concert concert2 = new Concert("C002", "Artist 2", "Venue 2", "25-09-2024", concert2Seats);
        concertBookingService.addConcert(concert2);

        User user1 = new User("U001", "John Doe", "john@example.com");
        User user2 = new User("U002", "Jane Smith", "jane@example.com");

        List<Concert> searchResults = concertBookingService.searchConcerts("Artist 1", "Venue 1", "25-09-2024");
        System.out.println("Search Results: ");
        for (Concert concert : searchResults) {
            System.out.println("Concert Details: " + concert.getId() +
                               " " + concert.getVenue() + " " + concert.getArtist());
        }

        //Book Tickets
        List<Seat> selectedSeats1 = selectSeats(concert1,3,SeatType.VIP);
        Booking booking1 = concertBookingService.bookTickets(user1,concert1,selectedSeats1);

        List<Seat> selectedSeats2 = selectSeats(concert2,2,SeatType.REGULAR);
        Booking booking2 = concertBookingService.bookTickets(user2,concert2,selectedSeats2);

        //Cancel Booking
        concertBookingService.cancelBooking(booking1.getId());

        //Book Tickets again
        List<Seat> selectedSeats3 = selectSeats(concert1,2,SeatType.PREMIUM);
        Booking booking3 = concertBookingService.bookTickets(user1,concert1,selectedSeats3);
    }
    private static List<Seat> generateSeats(int noOfSeats){
         List<Seat> seats = new ArrayList<>();
         for(int i=1;i<=noOfSeats;i++){
             String seatNumber = "S"+i;
             SeatType seatType = (i <= 10) ? SeatType.VIP : (i <= 30) ? SeatType.PREMIUM : SeatType.REGULAR;
             double price = (seatType == SeatType.VIP) ? 100.0 : (seatType == SeatType.PREMIUM) ? 75.0 : 50.0;
             seats.add(new Seat(seatNumber, seatNumber, seatType, price));
         }
         return seats;
    }
    private static List<Seat> selectSeats(Concert c1,int noOfSeats,SeatType seatType){
        List<Seat> selectedSeats = new ArrayList<>();
        List<Seat> availableSeats = c1.getSeats().stream().filter(seat ->
            seat.getSeatStatus() == SeatStatus.AVAILABLE && (seat.getSeatType()==seatType)).
                limit(noOfSeats).collect(Collectors.toList());
        selectedSeats.addAll(availableSeats);
        if(selectedSeats.size() != noOfSeats){
            System.out.println("Enough Seats are not available");
        }
        return selectedSeats;
    }
}

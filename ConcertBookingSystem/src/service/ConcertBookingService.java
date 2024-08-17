package service;
import model.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ConcertBookingService {
    private static ConcertBookingService concertBookingService;
    private Map<String, Concert> concerts;
    private Map<String, Booking> bookings;
    private final Object lock = new Object();

    public ConcertBookingService(){
        concerts = new ConcurrentHashMap<>();
        bookings = new ConcurrentHashMap<>();
    }
    public static ConcertBookingService getConcertBookingService(){
        if(concertBookingService==null)return new ConcertBookingService();
        return concertBookingService;
    }
    public void addConcert(Concert concert){
        concerts.put(concert.getId(),concert);
    }
    public Concert getConcert(String concertId){
        return concerts.get(concertId);
    }

    public List<Concert> searchConcerts(String artist, String venue, String dateTime){
       return concerts.values().stream().filter(concert -> concert.getArtist().equalsIgnoreCase(artist) &&
                concert.getVenue().equals(venue) && concert.getDateTime().equals(dateTime)
                ).collect(Collectors.toList());
    }

    public Booking bookTickets(User user, Concert concert, List<Seat> seats){
        synchronized (lock) {
            for (Seat seat : seats) {
                if (!seat.getSeatStatus().equals(SeatStatus.AVAILABLE)) {
                    throw new RuntimeException("Desired Seats are not available");
                }
            }
            Booking booking = new Booking(user, concert, seats);

            seats.forEach(Seat::bookSeat);
            booking.confirmBooking();
            String bookingId = generateBookingId();
            bookings.put(bookingId, booking);
            booking.setId(bookingId);
            processPayment(booking);
            System.out.println("Booking is complete: " + "Booking Id is: "+ bookingId);
            return booking;
        }
    }

    public void cancelBooking(String bookingId){
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            booking.cancelBooking();
            bookings.remove(bookingId);
        }
   }

   private void processPayment(Booking booking){
      System.out.println("Payment Processed for Booking: " + generateBookingId() + " Total Price: "
                         +booking.calculateTotalPrice());
   }

   private String generateBookingId(){
     return "BKG" + UUID.randomUUID();
   }
}

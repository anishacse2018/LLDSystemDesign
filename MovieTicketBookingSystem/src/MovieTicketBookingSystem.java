import model.Movie;
import model.Show;
import model.Theater;
import model.User;
import model.booking.Booking;
import model.booking.BookingStatus;
import model.seat.Seat;
import model.seat.SeatStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MovieTicketBookingSystem {

    private static MovieTicketBookingSystem movieTicketBookingSystem;
    private List<Movie> movies;
    private List<Theater> theaters;
    private Map<String, Show> shows;
    private Map<String, Booking> bookings;
    private static final String BOOKING_ID_PREFIX="BKG";
    private static final AtomicLong bookingCounter = new AtomicLong(0);

    public MovieTicketBookingSystem(){
        movies = new ArrayList<>();
        theaters = new ArrayList<>();
        shows = new ConcurrentHashMap<>();
        bookings = new ConcurrentHashMap<>();
    }

    public static MovieTicketBookingSystem getMovieTicketBookingSystem(){
        if(movieTicketBookingSystem == null){
            return new MovieTicketBookingSystem();
        }
        return movieTicketBookingSystem;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

    public void addTheater(Theater theater){
        this.theaters.add(theater);
    }

    public void addShow(Show show){
        shows.put(show.getId(), show);
    }

    public List<Movie> getMovies(){
        return this.movies;
    }

    public List<Theater> getTheaters() {
        return theaters;
    }
    public Show getShow(String showId){
        return shows.get(showId);
    }
    public synchronized Booking bookTickets(User user, Show show, List<Seat> seats){
        if(areSeatsAvailable(show,seats)){
            markSeatsAsBooked(show,seats);
            double totalPrice = calculateTotalPrice(seats);
            String bookingID = generateBookingId();
            Booking booking = new Booking(bookingID,user,show,seats,totalPrice, BookingStatus.PENDING);
            bookings.put(bookingID,booking);
            return booking;
        }
        return null;
    }

    private double calculateTotalPrice(List<Seat> seats){
        return seats.stream().mapToDouble(Seat::getPrice).sum();
    }

    private boolean areSeatsAvailable(Show show,List<Seat> seats){
       for(Seat seat : seats){
           Seat showSeat = show.getSeats().get(seat.getId());
           if(showSeat==null || showSeat.getStatus() != SeatStatus.AVAILABLE){
               return false;
           }
       }
       return true;
    }

    private void markSeatsAsBooked(Show show,List<Seat> selectedSeats){
        for(Seat seat:selectedSeats){
            Seat bookSeat = show.getSeats().get(seat.getId());
            bookSeat.setStatus(SeatStatus.BOOKED);
        }
    }

    private String generateBookingId() {
        long bookingNumber = bookingCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return BOOKING_ID_PREFIX + timestamp + String.format("%06d", bookingNumber);
    }

    public synchronized void confirmBooking(String bookingId){
        Booking booking = this.bookings.get(bookingId);
        if(booking!=null && booking.getStatus()==BookingStatus.PENDING){
            booking.setStatus(BookingStatus.CONFIRMED);
            //ProcessPayment
        }
    }

    public synchronized void cancelBooking(String bookingId){
        Booking booking = this.bookings.get(bookingId);
        if(booking!=null && booking.getStatus()!=BookingStatus.CANCELLED){
            booking.setStatus(BookingStatus.CANCELLED);
            markSeatsAsAvailable(booking.getShow(),booking.getSeatList());
            //Process refund
        }
    }

    private void markSeatsAsAvailable(Show show,List<Seat> selectedSeats){
        for(Seat seat:selectedSeats){
            Seat bookSeat = show.getSeats().get(seat.getId());
            bookSeat.setStatus(SeatStatus.AVAILABLE);
        }
    }
}

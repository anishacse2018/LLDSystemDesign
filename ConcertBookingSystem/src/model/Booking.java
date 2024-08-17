package model;


import java.util.List;

public class Booking {
    private String id;
    private User user;

    public String getId() {
        return id;
    }

    private Concert concert;
    private Double price;
    private BookingStatus status;

    public void setId(String id) {
        this.id = id;
    }

    private List<Seat> seats;

    public Booking(User user, Concert concert,List<Seat> seats) {
        this.user = user;
        this.concert = concert;
        this.seats = seats;
        this.price = calculateTotalPrice();
        this.status = BookingStatus.PENDING;
    }

    public Double calculateTotalPrice(){
        return seats.stream().mapToDouble(Seat::getPrice).sum();
    }
    public void confirmBooking(){
        if(status.equals(BookingStatus.PENDING)){
            status = BookingStatus.CONFIRMED;
        }
    }

    public void cancelBooking(){
       if(status.equals(BookingStatus.CONFIRMED)){
           status = BookingStatus.CANCELLED;
           seats.forEach(Seat::releaseSeat);
           System.out.println("Booking is cancelled");
       }
    }
}

package model.booking;

import model.Show;
import model.User;
import model.seat.Seat;

import java.util.List;


public class Booking {
    private final double totalPrice;
    private final String bookingId;
    private final User user;
    private final Show show;
    private final List<Seat> seatList;
    private BookingStatus status;

    public Booking(String id, User user, Show show, List<Seat> seats, double totalPrice, BookingStatus status) {
        this.bookingId = id;
        this.user = user;
        this.show = show;
        this.seatList = seats;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}

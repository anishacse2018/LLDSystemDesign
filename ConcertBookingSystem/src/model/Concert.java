package model;
import java.time.LocalDateTime;
import java.util.List;

public class Concert {
    public Concert(String id, String artist, String venue, String dateTime, List<Seat> seats) {
        this.id = id;
        this.artist = artist;
        this.venue = venue;
        this.dateTime = dateTime;
        this.seats = seats;
    }

    private String id;
    private String artist;
    private String venue;
    private String dateTime;
    List<Seat> seats;

    public String getId() {
        return id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String getArtist() {
        return artist;
    }

    public String getVenue() {
        return venue;
    }
    public String getDateTime() {
        return dateTime;
    }
}

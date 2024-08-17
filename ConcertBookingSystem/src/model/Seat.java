package model;

public class Seat {

   private String id;
   private String seatNumber;
   private SeatType seatType;
   private Double price;
   private SeatStatus seatStatus;

   public Seat(String id, String seatNumber, SeatType seatType, Double price) {
      this.id = id;
      this.seatNumber = seatNumber;
      this.seatType = seatType;
      this.price = price;
      this.seatStatus = SeatStatus.AVAILABLE;
   }

   public String getId() {
      return id;
   }

   public String getSeatNumber() {
      return seatNumber;
   }

   public SeatType getSeatType() {
      return seatType;
   }

   public Double getPrice() {
      return price;
   }

   public SeatStatus getSeatStatus() {
      return seatStatus;
   }

   public void bookSeat(){
       if(seatStatus.equals(SeatStatus.AVAILABLE)){
          this.seatStatus = SeatStatus.BOOKED;
       }else{
          throw  new RuntimeException("Seat Not available");
       }
   }

   public void releaseSeat(){
       if(seatStatus.equals(SeatStatus.BOOKED)){
          this.seatStatus = SeatStatus.AVAILABLE;
       }
   }
}

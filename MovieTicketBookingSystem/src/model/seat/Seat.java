package model.seat;

public class Seat {
    private final SeatType type;
    private String id;
    private int row;
    private int column;
    private double price;
    private SeatStatus status;

    public Seat(String id, int row, int column, double price, SeatType type, SeatStatus status) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.price = price;
        this.type = type;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SeatType getType() {
        return type;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}

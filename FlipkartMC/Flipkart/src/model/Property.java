package model;

public class Property {
    private Integer id;
    private String title;
    private String location;
    private Double price;
    private Size sizeOfProperty;
    private RoomType roomType;
    private ListingType listingType;
    private Status propertyStatus;

    public Property(Integer id,String title, String location, Double price, Size sizeOfProperty, ListingType listingType, Status propertyStatus,RoomType roomType) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.price = price;
        this.sizeOfProperty = sizeOfProperty;
        this.listingType = listingType;
        this.propertyStatus = propertyStatus;
        this.roomType = roomType;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Size getSizeOfProperty() {
        return sizeOfProperty;
    }

    public void setSizeOfProperty(Size sizeOfProperty) {
        this.sizeOfProperty = sizeOfProperty;
    }

    public ListingType getListingType() {
        return listingType;
    }

    public void setListingType(ListingType listingType) {
        this.listingType = listingType;
    }

    public Status getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(Status propertyStatus) {
        this.propertyStatus = propertyStatus;
    }
}

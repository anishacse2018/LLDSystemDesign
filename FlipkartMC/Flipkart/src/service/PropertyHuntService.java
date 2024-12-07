package service;

import model.*;
import strategy.SearchStrategyType;
import java.util.List;

import static strategy.SortBy.PRICE;

public class PropertyHuntService {
    private static PropertyHuntService propertyHuntService = new PropertyHuntService();
    private PropertyService propertyService;
    private UserService userService;
    PropertyHuntService(){
      this.userService = new UserService();
      this.propertyService = new PropertyService();
    }
    public static  PropertyHuntService getPropertyHuntService(){
        return propertyHuntService;
    }

    public void execute(){
        User u1 = new User(1,"Anisha");
        userService.addUser(u1);
        User u2 = new User(2,"Akash");
        userService.addUser(u2);
        Property p1 = new Property(1,"house1", "loc1", 123.00,new Size(1000,"sqft"), ListingType.RENT, Status.AVAILABLE,RoomType.OneBHK);
        Property p2 = new Property(2,"house2", "loc2", 50.00,new Size(10000,"sqft"), ListingType.SALE, Status.SOLD,RoomType.TwoBHK);
        propertyService.addProperty(p1);
        propertyService.addProperty(p2);
        userService.shortListProperties(u1,p1);
        userService.viewShortListedProperties(u1);
        List<Property> filteredProperties = propertyService.searchProperties(List.of(SearchStrategyType.LOCATION.name()),List.of("loc1"),PRICE.name());
        printPropertyDetails(filteredProperties);
    }

    public void printPropertyDetails(List<Property> properties){
        for(Property property:properties){
            System.out.println("Property Details: " + property.getTitle() + " " + property.getPropertyStatus() +  " " + property.getListingType() + " " + property.getPrice());
        }
    }

}

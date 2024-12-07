package service;

import model.ListingType;
import model.Property;
import model.Status;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    public void addUser(User user){
        userMap.put(user.getId(),user);
    }
    public void removeUser(Integer id){
        userMap.remove(id);
    }

    public void buyProperty(User u, Property property){
        if(u.isLoggedInUser()){
            if(property.getListingType().equals(ListingType.SALE) && property.getPropertyStatus().equals(Status.AVAILABLE)){
                u.getPropertiesBoughtByUser().add(property);
                property.setPropertyStatus(Status.SOLD);
            }else{
                System.out.println("Property is not for sale!!");
            }
        }

    }


    public void sellProperty(User u,Property property){
        if(property.getPropertyStatus().equals(Status.AVAILABLE)){
            u.getPropertiesSoldByUser().add(property);
            property.setPropertyStatus(Status.SOLD);
        }else{
            System.out.println("Property is already sold!!");
        }
    }

    public void listProperties(User u,Property property){
        u.getListedByUser().add(property);

    }
    public void shortListProperties(User u,Property property){
        u.getShortlistedByUser().add(property);
    }
    public void viewShortListedProperties(User u){
        List<Property> shortListedProperties = u.getShortlistedByUser();
        for(Property property:shortListedProperties){
            System.out.println("Property Details : " + property.getTitle());
        }

    }
}

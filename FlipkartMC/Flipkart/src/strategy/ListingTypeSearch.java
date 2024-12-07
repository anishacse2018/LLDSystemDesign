package strategy;

import model.Property;

import java.util.List;

public class ListingTypeSearch<String> implements SearchStrategy<String>{
    @Override
    public List<Property> searchProperties(List<Property> properties,String field) {
        return properties.stream().filter(property -> property.getListingType().equals(field)).toList();
    }
}

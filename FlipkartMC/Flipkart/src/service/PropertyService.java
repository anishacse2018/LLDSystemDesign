package service;

import model.Property;
import strategy.CompositeSearchStrategy;
import strategy.SearchStrategySelectionFactory;
import strategy.SortBy;
import utils.SortByPrice;
import utils.SortBySize;

import java.util.*;

public class PropertyService {

    Map<Integer, Property> propertyMap;
    private CompositeSearchStrategy compositeSearchStrategy;

    PropertyService(){
        compositeSearchStrategy = new CompositeSearchStrategy();
        propertyMap = new HashMap<>();
    }

    public void addProperty(Property property){
        propertyMap.put(property.getId(),property);
    }
    public void removeProperty(Integer proppertyId){
        propertyMap.remove(proppertyId);
    }

    public List<Property> searchProperties(List<String> searchBy, List<String> fields,String sortBy){
        List<Property> allProperties =  (new ArrayList<>(propertyMap.values()));
        int fieldIndex = 0;
        for(String strategy: searchBy){
            compositeSearchStrategy.addSearchStrategy(SearchStrategySelectionFactory.selectStrategy(strategy));
            compositeSearchStrategy.addSearchFields(fields.get(fieldIndex));
            fieldIndex++;
        }
        List<Property> filteredOutProperties = compositeSearchStrategy.searchProperties(allProperties,null);
        if(Objects.isNull(sortBy))return filteredOutProperties;
        return sortPropertiesBy(filteredOutProperties,sortBy);
    }

    public List<Property> sortPropertiesBy(List<Property> properties,String sortBy){
        if(sortBy.equals(SortBy.PRICE)){
            Collections.sort(properties,new SortByPrice());
        }else{
            Collections.sort(properties,new SortBySize());
        }
        return properties;
    }
}

package strategy;

import model.Property;

import java.util.ArrayList;
import java.util.List;

public class CompositeSearchStrategy implements SearchStrategy<String>{
    public List<SearchStrategy<String>> searchStrategies;
    public List<String> searchField;

    public CompositeSearchStrategy() {
        this.searchStrategies = new ArrayList<>();
        this.searchField = new ArrayList<>();
    }

    public void addSearchFields(String field){
        searchField.add(field);
    }
    public void addSearchStrategy(SearchStrategy<String> searchStrategy) {
        if (searchStrategy != null) {
            searchStrategies.add(searchStrategy);
        }
    }

    public void removeSearchStrategy(SearchStrategy strategy){
        searchStrategies.remove(strategy);
    }

    public List<Property> searchProperties(List<Property> properties,String field) {
        List<Property> propertiesList = properties;
        int fieldIndex = 0;
        for(SearchStrategy searchStrategy: searchStrategies){
            propertiesList = searchStrategy.searchProperties(propertiesList,searchField.get(fieldIndex));
            fieldIndex++;
        }
        return propertiesList;
    }

}

package strategy;

import model.Property;

import java.util.List;

public interface SearchStrategy<T> {
    public List<Property> searchProperties(List<Property> properties,T searchField);
}


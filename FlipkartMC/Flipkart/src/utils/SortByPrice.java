package utils;
import model.Property;
import java.util.Comparator;

public class SortByPrice implements Comparator<Property> {
    public int compare(Property a, Property b)
    {
        return (int) (a.getPrice() - b.getPrice());
    }
}
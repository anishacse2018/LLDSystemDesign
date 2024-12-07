package utils;

import model.Property;

import java.util.Comparator;

public class SortBySize implements Comparator<Property> {

    public int compare(Property a, Property b)
    {
        //Assuming unit is same
        return (int) (a.getSizeOfProperty().magnitude - b.getSizeOfProperty().magnitude);
    }
}
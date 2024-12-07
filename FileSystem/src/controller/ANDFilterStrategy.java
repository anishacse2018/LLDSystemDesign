package controller;

public class ANDFilterStrategy implements FilterStrategy {

    private FilterStrategy filterStrategy1;
    private FilterStrategy filterStrategy2;

    @Override
    public boolean filterBy(Object fileName, FileSystem entity) {
        return filterStrategy1.filterBy(fileName, entity) && filterStrategy2.filterBy(fileName, entity);
    }
}


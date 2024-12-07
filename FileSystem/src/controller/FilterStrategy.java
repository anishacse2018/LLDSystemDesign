package controller;

public interface FilterStrategy<T> {
    boolean filterBy(T fileName, FileSystem entity);
}



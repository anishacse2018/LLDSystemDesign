package controller;

public class NameFilterStrategy implements FilterStrategy<String> {

    @Override
    public boolean filterBy(String fileName, FileSystem entity) {
        return fileName.equalsIgnoreCase(entity.name);
    }
}

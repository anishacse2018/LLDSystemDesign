package controller;

public class ExtensionFilterStrategy implements FilterStrategy<String> {

    @Override
    public boolean filterBy(String fileName, FileSystem entity) {
        return fileName.equalsIgnoreCase(entity.path);
    }
}

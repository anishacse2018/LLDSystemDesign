package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory extends FileSystem {

    private final FilterStrategy filterStrategy;
    private List<FileSystem> fileSystemList;

    Directory(String path, String name) {
        super(path, name);
        this.isDirectory = true;
        fileSystemList = new ArrayList<>();
        filterStrategy = new NameFilterStrategy();
    }

    public List<FileSystem> getFileSystemList() {
        return fileSystemList;
    }

    public void setFileSystemList(List<FileSystem> fileSystemList) {
        this.fileSystemList = fileSystemList;
    }

    public List<FileSystem> searchFiles(String fileName, List<FileSystem> matchingList, FileSystem fileSystem) {
        if (Objects.isNull(fileName)) return null;
        for (FileSystem entity : fileSystemList) {
            if (!entity.isDirectory) {
                if (filterStrategy.filterBy(fileName, entity)) {
                    matchingList.add(entity);
                }
            } else {
                searchFiles(fileName, matchingList, entity);
            }
        }
        return matchingList;
    }
}

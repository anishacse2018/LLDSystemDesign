package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileService {


    Map<String, Directory> directoryMap = new HashMap<>();

    public List<FileSystem> getFileNames(String directoryPath, String fileName) {
        Directory directory = directoryMap.get(directoryPath);
        List<FileSystem> matchingList = new ArrayList<>();
        return directory.searchFiles(fileName, matchingList, directory);
    }

    public void createDirectory(Directory directory) {
        directoryMap.put(directory.path, directory);
    }

    public void addDirectories(String path, FileSystem fileSystem) {
        directoryMap.get(path).getFileSystemList().add(fileSystem);
    }


}

package controller;

import java.util.List;


public class FileController {

    private FileService fileService;


    public List<FileSystem> getFileName(String directoryPath, String fileName) {
        return fileService.getFileNames(directoryPath, fileName);
    }

}

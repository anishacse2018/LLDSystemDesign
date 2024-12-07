package controller;

public class File extends FileSystem {

    FileProperties properties;

    File(String path, String name) {
        super(path, name);
        this.isDirectory = false;
    }
}

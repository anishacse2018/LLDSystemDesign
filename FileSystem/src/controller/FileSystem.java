package controller;

public abstract class FileSystem {
    public boolean isDirectory;
    public String path;
    public String name;

    FileSystem(String path, String name) {
        this.path = path;
        this.name = name;
    }
}



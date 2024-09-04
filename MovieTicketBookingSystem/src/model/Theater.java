package model;

import java.util.List;

public class Theater {
    private String id;
    private String name;
    private List<Show> shows;
    private String location;

    public Theater(String id, String name, List<Show> shows, String location) {
        this.id = id;
        this.name = name;
        this.shows = shows;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

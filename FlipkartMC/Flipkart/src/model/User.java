package model;

import java.util.ArrayList;
import java.util.List;

public class User {
  private Integer id;
  private String name;
  private boolean loggedInUser;
  List<Property> listedByUser;
  List<Property> shortlistedByUser;
  List<Property> propertiesSoldByUser;
  List<Property> propertiesBoughtByUser;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.listedByUser = new ArrayList<>();
        this.shortlistedByUser = new ArrayList<>();
        this.propertiesSoldByUser = new ArrayList<>();
        this.propertiesBoughtByUser = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(boolean loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public List<Property> getListedByUser() {
        return listedByUser;
    }

    public void setListedByUser(List<Property> listedByUser) {
        this.listedByUser = listedByUser;
    }

    public List<Property> getShortlistedByUser() {
        return shortlistedByUser;
    }

    public void setShortlistedByUser(List<Property> shortlistedByUser) {
        this.shortlistedByUser = shortlistedByUser;
    }

    public List<Property> getPropertiesSoldByUser() {
        return propertiesSoldByUser;
    }

    public void setPropertiesSoldByUser(List<Property> propertiesSoldByUser) {
        this.propertiesSoldByUser = propertiesSoldByUser;
    }

    public List<Property> getPropertiesBoughtByUser() {
        return propertiesBoughtByUser;
    }

    public void setPropertiesBoughtByUser(List<Property> propertiesBoughtByUser) {
        this.propertiesBoughtByUser = propertiesBoughtByUser;
    }
}

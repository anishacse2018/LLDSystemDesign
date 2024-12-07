package model;

public class RestaurantAdmin {
    private final String name;
    private final Integer noOfTables;
    private final Menu menu;

    public RestaurantAdmin(String name, Integer noOfTables, Menu menu) {
        this.name = name;
        this.noOfTables = noOfTables;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public Integer getNoOfTables() {
        return noOfTables;
    }

    public Menu getMenu() {
        return menu;
    }
}

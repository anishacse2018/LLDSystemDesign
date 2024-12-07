package model;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, MenuItem> menuItems;

    public Menu() {
        menuItems = new HashMap<>();
    }

    public Map<String, MenuItem> getMenuItems() {
        return menuItems;
    }
}

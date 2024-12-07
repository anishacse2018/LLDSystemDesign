package service;

import model.Menu;
import model.MenuItem;
import model.RestaurantAdmin;

public class RestaurantAdminService {

    private MenuService menuService;
    private RestaurantAdmin restaurantAdmin;

    public void addItemToMenu(MenuItem i, Menu m) {
        m.getMenuItems().putIfAbsent(i.getName(), i);
    }

    public void updateMenuItem(MenuItem i, Menu m) {
        m.getMenuItems().put(i.getName(), i);
    }

    public void removeItemFromMenu(MenuItem i, Menu m) {
        m.getMenuItems().remove(i.getName());
    }
}

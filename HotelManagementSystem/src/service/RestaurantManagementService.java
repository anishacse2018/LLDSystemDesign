package service;

import model.Menu;
import model.MenuItem;
import model.RestaurantAdmin;

public class RestaurantManagementService {
    private final RestaurantAdmin restaurantAdmin;
    private RestaurantAdminService restaurantAdminService;
    private MenuService menuService;

    public RestaurantManagementService() {
        restaurantAdmin = new RestaurantAdmin("Anisha", 10, new Menu());
    }

    public void addItemsToMenu(MenuItem menuItem) {
        restaurantAdminService.addItemToMenu(menuItem, restaurantAdmin.getMenu());
    }

    public void removeItemsFromMenu(MenuItem menuItem) {
        restaurantAdminService.removeItemFromMenu(menuItem, restaurantAdmin.getMenu());
    }

    public void updateItemsInMenu(MenuItem menuItem) {
        restaurantAdminService.updateMenuItem(menuItem, restaurantAdmin.getMenu());
    }
}

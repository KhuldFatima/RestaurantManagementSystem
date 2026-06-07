package Controller;

import Dto.ApiResponse;
import Service.MenuService;
import Model.MenuItem;
import java.util.List;

public class MenuController {
    private final MenuService menuService = new MenuService();

    public ApiResponse getActiveMenu() {
        try {
            List<MenuItem> menuList = menuService.getAllMenuItems();
            return new ApiResponse("success", "Menu fetched successfully from database.", menuList);
        } catch (Exception e) {
            return new ApiResponse("error", "Failed to compile database items: " + e.getMessage(), null);
        }
    }
}
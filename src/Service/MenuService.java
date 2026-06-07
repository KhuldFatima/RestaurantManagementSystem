package Service;

import Model.MenuItem;
import Repository.MenuItemRepository;
import java.util.List;

public class MenuService {
    private final MenuItemRepository menuItemRepository = new MenuItemRepository();

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.getAllMenuItems();
    }
}
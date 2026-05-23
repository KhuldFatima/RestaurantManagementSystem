package Service;

import controller.MenuController;
import model.MenuItem;
import util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class MenuService {
    private MenuController menuController = new MenuController();

    public List<MenuItem> getAllItems() {
        return menuController.getAllMenuItems();
    }

    public List<MenuItem> getAvailableItems() {
        return menuController.getAllMenuItems()
                .stream()
                .filter(MenuItem::isAvailable)
                .collect(Collectors.toList());
    }

    public List<MenuItem> getItemsByCategory(String category) {
        return menuController.getAllMenuItems()
                .stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Returns error message string, or null if success
    public String addItem(String name, String priceText, String category) {
        if (Validator.isNullOrEmpty(name))     return "Item name is required.";
        if (!Validator.isValidPrice(priceText)) return "Invalid price. Must be a positive number.";
        if (Validator.isNullOrEmpty(category)) return "Category is required.";

        double price = Double.parseDouble(priceText.trim());
        boolean success = menuController.addMenuItem(name.trim(), price, category.trim());
        return success ? null : "Failed to add item. Please try again.";
    }

    // Returns error message string, or null if success
    public String deleteItem(int id) {
        if (id <= 0) return "Invalid item selected.";
        boolean success = menuController.deleteMenuItem(id);
        return success ? null : "Failed to delete item.";
    }

    public MenuItem findById(int id) {
        return menuController.getAllMenuItems()
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
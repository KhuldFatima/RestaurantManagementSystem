package Service;

import Controller.AuthController;
import Model.User;
import Util.Validator;

public class AuthService {
    private AuthController authController = new AuthController();

    // Returns logged-in User or null if credentials wrong
    public User login(String username, String password) {
        if (!Validator.isValidUsername(username)) return null;
        if (!Validator.isValidPassword(password)) return null;
        return authController.login(username.trim(), password);
    }

    // Returns true if the user has admin privileges
    public boolean isAdmin(User user) {
        if (user == null) return false;
        return user.getRole().equalsIgnoreCase("admin");
    }

    // Returns true if the user can take orders (waiter or admin)
    public boolean canTakeOrders(User user) {
        if (user == null) return false;
        String role = user.getRole().toLowerCase();
        return role.equals("waiter") || role.equals("admin");
    }

    // Returns true if the user can process payments (cashier or admin)
    public boolean canProcessPayment(User user) {
        if (user == null) return false;
        String role = user.getRole().toLowerCase();
        return role.equals("cashier") || role.equals("admin");
    }
}
package Util;
public class Validator {

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidPrice(String priceText) {
        if (isNullOrEmpty(priceText)) return false;
        try {
            double price = Double.parseDouble(priceText.trim());
            return price > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidQuantity(int qty) {
        return qty > 0 && qty <= 100;
    }

    public static boolean isValidUsername(String username) {
        if (isNullOrEmpty(username)) return false;
        return username.trim().length() >= 3;
    }

    public static boolean isValidPassword(String password) {
        if (isNullOrEmpty(password)) return false;
        return password.length() >= 4;
    }

    public static boolean isValidTableNumber(String number) {
        if (isNullOrEmpty(number)) return false;
        try {
            int n = Integer.parseInt(number.trim());
            return n > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidCapacity(String capacity) {
        if (isNullOrEmpty(capacity)) return false;
        try {
            int c = Integer.parseInt(capacity.trim());
            return c > 0 && c <= 20;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
package Util;

public class Constants {

    // User roles
    public static final String ROLE_ADMIN   = "ADMIN";
    public static final String ROLE_WAITER  = "WAITER";
    public static final String ROLE_CASHIER = "CASHIER";

    // Order status
    public static final String ORDER_OPEN      = "OPEN";
    public static final String ORDER_PAID      = "PAID";
    public static final String ORDER_CANCELLED = "CANCELLED";

    // Table status
    public static final String TABLE_AVAILABLE = "AVAILABLE";
    public static final String TABLE_OCCUPIED  = "OCCUPIED";
    public static final String TABLE_RESERVED  = "RESERVED";

    // Menu categories
    public static final String CAT_MAIN    = "Main Course";
    public static final String CAT_STARTER = "Starter";
    public static final String CAT_DRINKS  = "Drinks";
    public static final String CAT_DESSERT = "Dessert";
    public static final String CAT_BREAD   = "Bread";
    public static final String CAT_SIDE    = "Side";

    // Messages
    public static final String MSG_LOGIN_FAILED    = "Invalid username or password.";
    public static final String MSG_ORDER_SUCCESS   = "Order placed successfully!";
    public static final String MSG_ORDER_EMPTY     = "Please add at least one item to the order.";
    public static final String MSG_SELECT_TABLE    = "Please select a table first.";
    public static final String MSG_SELECT_ITEM     = "Please select an item first.";
    public static final String MSG_CONFIRM_DELETE  = "Are you sure you want to delete this?";
    public static final String MSG_FIELD_EMPTY     = "All fields are required.";
    public static final String MSG_INVALID_PRICE   = "Price must be a positive number.";
    public static final String MSG_DB_ERROR        = "Database error. Please try again.";
}
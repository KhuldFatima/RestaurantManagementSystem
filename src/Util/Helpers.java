package Util;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helpers {

    public static String formatCurrency(double amount) {
        return String.format("Rs. %.2f", amount);
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    public static String formatDate(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy, hh:mm a");
        return sdf.format(date);
    }

    public static double roundToTwo(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public static String capitalize(String text) {
        if (isNullOrEmpty(text)) return text;
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
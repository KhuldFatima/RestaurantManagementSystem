package Service;
import java.time.LocalDate;
import java.time.DayOfWeek;
public class DiscountService {
    public double calculateDiscountPercentage(String paymentMethod, LocalDate orderDate) {
        double totalDiscount = 0.0;
        // 10% off on Askari and Meezan Bank Cards
        if (paymentMethod != null) {
            String methodUpper = paymentMethod.toUpperCase().trim();
            if (methodUpper.contains("ASKARI") || methodUpper.contains("MEEZAN")) {
                totalDiscount += 0.10;
            }
        }
        // 5% off on every first Wednesday of the month
        if (orderDate.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            //Wednesday discount
            if (orderDate.getDayOfMonth() <= 7) {
                totalDiscount += 0.05;
            }
        }
        return totalDiscount;
    }
    // 16% GST tax.
    public double calculateFinalBill(double subtotal, double discountPercentage) {
        double discountAmount = subtotal * discountPercentage;
        double discountedSubtotal = subtotal - discountAmount;
        double taxAmount = discountedSubtotal * 0.16;
        return discountedSubtotal + taxAmount;
    }

    public double calculateTaxAmount(double discountedSubtotal) {
        return discountedSubtotal * 0.16;
    }
}
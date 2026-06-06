package Service;

import Repository.DailySalesRepository;
import java.time.LocalDate;

public class OrderService {
    private DiscountService discountService = new DiscountService();
    private DailySalesRepository salesRepository = new DailySalesRepository();

    public boolean processAndRecordOrder(double subtotal, String paymentMethod) {

        double discountPercentage = discountService.calculateDiscountPercentage(paymentMethod, LocalDate.now());
        double discountAmount = subtotal * discountPercentage;

        double discountedSubtotal = subtotal - discountAmount;
        double taxAmount = discountedSubtotal * 0.16; //GST
        double finalTotal = discountedSubtotal + taxAmount;


        return salesRepository.recordSale(subtotal, discountAmount, taxAmount, finalTotal, paymentMethod);
    }
}
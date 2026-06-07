package Service;

import Model.Order;
import Repository.OrderRepository;
import Repository.DailySalesRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderService {
    private final OrderRepository orderRepository = new OrderRepository();
    private final DailySalesRepository dailySalesRepository = new DailySalesRepository();
    private final DiscountService discountService = new DiscountService();

    public boolean processAndRecordOrder(double subtotal, String paymentMethod, int tableNumber) {
        LocalDate today = LocalDate.now();

        double discountPercent = discountService.calculateDiscountPercentage(paymentMethod, today);
        double discountAmount = subtotal * discountPercent;
        double discountedSubtotal = subtotal - discountAmount;

        double taxAmount = discountService.calculateTaxAmount(discountedSubtotal);
        double finalTotal = discountedSubtotal + taxAmount;

        Order order = new Order();
        order.setTableNumber(tableNumber); // Table number is now passed in from the request
        order.setSubtotal(subtotal);
        order.setDiscountAmount(discountAmount);
        order.setTaxAmount(taxAmount);
        order.setTotalAmount(finalTotal);
        order.setPaymentMethod(paymentMethod);
        order.setStatus("COMPLETED");
        order.setOrderTime(LocalDateTime.now());

        int generatedId = orderRepository.saveOrder(order);

        if (generatedId == -1) {
            return false; // Order saving step failed
        }

        return dailySalesRepository.recordSale(subtotal, discountAmount, taxAmount, finalTotal, paymentMethod);
    }
}
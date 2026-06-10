package Service;

import Dto.OrderRequest;
import Model.Order;
import Model.OrderItem;
import Repository.OrderRepository;
import Repository.OrderItemRepository;
import Repository.DailySalesRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository = new OrderRepository();
    private final OrderItemRepository orderItemRepository = new OrderItemRepository();
    private final DailySalesRepository dailySalesRepository = new DailySalesRepository();
    private final DiscountService discountService = new DiscountService();

    // OLD signature was: processAndRecordOrder(double subtotal, String paymentMethod)
    // NEW: takes the full request so we can save cart items + real table number
    public boolean processAndRecordOrder(OrderRequest request) {
        double subtotal     = request.getSubtotal();
        String paymentMethod = request.getPaymentMethod();
        List<OrderItem> cartItems = request.getCartItems();

        LocalDate today = LocalDate.now();

        double discountPercent    = discountService.calculateDiscountPercentage(paymentMethod, today);
        double discountAmount     = subtotal * discountPercent;
        double discountedSubtotal = subtotal - discountAmount;
        double taxAmount          = discountService.calculateTaxAmount(discountedSubtotal);
        double finalTotal         = discountedSubtotal + taxAmount;

        Order order = new Order();
        order.setTableNumber(request.getTableNumber()); // Fix 2: use real table number
        order.setSubtotal(subtotal);
        order.setDiscountAmount(discountAmount);
        order.setTaxAmount(taxAmount);
        order.setTotalAmount(finalTotal);
        order.setPaymentMethod(paymentMethod);
        order.setStatus("COMPLETED");
        order.setOrderTime(LocalDateTime.now());

        int generatedId = orderRepository.saveOrder(order);
        if (generatedId == -1) return false;

        // Fix 3: actually save the line items
        boolean itemsSaved = orderItemRepository.saveOrderItems(generatedId, cartItems);
        if (!itemsSaved) return false;

        return dailySalesRepository.recordSale(subtotal, discountAmount, taxAmount, finalTotal, paymentMethod);
    }
}
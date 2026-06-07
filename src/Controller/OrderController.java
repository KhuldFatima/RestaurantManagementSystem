package Controller;

import Dto.OrderRequest;
import Dto.ApiResponse;
import Service.OrderService;

public class OrderController {
    private final OrderService orderService = new OrderService();

    public ApiResponse processCheckoutOrder(OrderRequest request) {
        if (request == null || request.getCartItems() == null || request.getCartItems().isEmpty()) {
            return new ApiResponse("fail", "Order cart cannot be empty.", null);
        }

        if (request.getSubtotal() <= 0) {
            return new ApiResponse("fail", "Invalid transactional subtotal base.", null);
        }

        if (request.getTableNumber() <= 0) {
            return new ApiResponse("fail", "A valid table number is required to process the order.", null);
        }

        try {
            // Evaluates pricing thresholds, 16% taxes, and active promotional campaign cuts
            boolean isSaved = orderService.processAndRecordOrder(
                    request.getSubtotal(),
                    request.getPaymentMethod(),
                    request.getTableNumber()
            );

            if (isSaved) {
                return new ApiResponse("success", "Order processed. Dispatched to Kitchen Display and Database Ledger.", null);
            } else {
                return new ApiResponse("error", "Transaction rejected by database system.", null);
            }
        } catch (Exception e) {
            return new ApiResponse("error", "Server processing fault: " + e.getMessage(), null);
        }
    }
}
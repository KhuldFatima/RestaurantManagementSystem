package Servlet;

import Controller.OrderController;
import Dto.OrderRequest;
import Dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OrderServlet {
    private final OrderController orderController = new OrderController();

    @PostMapping("/order")
    public ApiResponse placeOrder(@RequestBody OrderRequest request) {
        return orderController.processCheckoutOrder(request);
    }
}
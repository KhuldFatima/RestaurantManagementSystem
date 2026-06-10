package Servlet;

import Controller.OrderController;
import Dto.OrderRequest;
import Dto.ApiResponse;
import Model.OrderItem;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/api/order")
public class OrderServlet extends HttpServlet {
    private final OrderController orderController = new OrderController();
    private final Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setContentType("application/json");
        res.setHeader("Access-Control-Allow-Origin", "*");

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
        }

        OrderRequest orderRequest = gson.fromJson(sb.toString(), OrderRequest.class);
        ApiResponse response = orderController.processCheckoutOrder(orderRequest);

        res.getWriter().write(gson.toJson(response));
    }
}
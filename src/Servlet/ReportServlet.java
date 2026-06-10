package Servlet;

import Controller.ReportController;
import Dto.ApiResponse;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ReportServlet {
    private final ReportController reportController = new ReportController();


    @GetMapping("/report")
    public ApiResponse getDailyReport() {
        return reportController.generateDailySalesReport();
    }
}
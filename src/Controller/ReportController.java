package Controller;

import Dto.ApiResponse;
import Service.ReportService;
import java.util.Map;

public class ReportController {
    private final ReportService reportService = new ReportService();

    public ApiResponse generateDailySalesReport() {
        try {
            // Compiles totals including revenue generated, discounts distributed, and taxes collected
            Map<String, Object> summaryMetrics = reportService.getDailyPerformanceMetrics();
            return new ApiResponse("success", "Financial metrics compiled successfully.", summaryMetrics);
        } catch (Exception e) {
            return new ApiResponse("error", "Unable to pull operations overview report: " + e.getMessage(), null);
        }
    }
}
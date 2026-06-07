package Controller;

import Dto.TableRequest;
import Dto.ApiResponse;
import Service.TableService;

public class TableController {
    private final TableService tableService = new TableService();

    public ApiResponse updateTableStatus(TableRequest request) {
        if (request == null || request.getTableNumber() <= 0 || request.getNewStatus() == null) {
            return new ApiResponse("fail", "Invalid table index or status criteria.", null);
        }

        boolean updated = tableService.changeStatus(request.getTableNumber(), request.getNewStatus());

        if (updated) {
            return new ApiResponse("success", "Table " + request.getTableNumber() + " shifted to: " + request.getNewStatus(), null);
        } else {
            return new ApiResponse("error", "Failed to update layout constraints for target table.", null);
        }
    }
}
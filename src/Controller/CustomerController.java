package Controller;

import Dto.CustomerRequest;
import Dto.ApiResponse;
import Service.CustomerService;

public class CustomerController {
    private final CustomerService customerService = new CustomerService();

    public ApiResponse registerCustomer(CustomerRequest request) {
        if (request == null || request.getName() == null || request.getPhone() == null) {
            return new ApiResponse("fail", "Customer name and valid phone number are required.", null);
        }

        boolean unique = customerService.isPhoneUnique(request.getPhone());
        if (!unique) {
            return new ApiResponse("fail", "A customer with this phone number already exists.", null);
        }

        boolean saved = customerService.saveCustomer(request);
        if (saved) {
            return new ApiResponse("success", "Customer account registered successfully.", null);
        } else {
            return new ApiResponse("error", "Database write error occurred while saving profile.", null);
        }
    }
}
package Service;

import Dto.CustomerRequest;
import Repository.CustomerRepository;

public class CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepository();

    public boolean isPhoneUnique(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return false;
        }
        return customerRepository.isPhoneUnique(phone.trim());
    }

    public boolean saveCustomer(CustomerRequest request) {

        if (request.getName() == null || request.getName().trim().isEmpty()) {
            return false;
        }
        return customerRepository.saveCustomer(request);
    }
}
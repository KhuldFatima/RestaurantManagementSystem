package Controller;

import Dto.LoginRequest;
import Dto.ApiResponse;
import Service.AuthService;
import Model.User;

public class AuthController {
    // Intended to connect with your Service Layer class
    private final AuthService authService = new AuthService();

    public ApiResponse login(LoginRequest request) {
        if (request == null || request.getUsername() == null || request.getPassword() == null) {
            return new ApiResponse("fail", "Invalid request body parameters", null);
        }

        // Validate credentials against user data records
        User authenticatedUser = authService.authenticate(request.getUsername(), request.getPassword());

        if (authenticatedUser != null) {
            return new ApiResponse("success", "Login successful! Welcome back, " + authenticatedUser.getName(), authenticatedUser);
        } else {
            return new ApiResponse("fail", "Invalid username or password combinations.", null);
        }
    }
}
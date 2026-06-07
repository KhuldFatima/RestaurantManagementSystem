package Controller;

import Dto.LoginRequest;
import Dto.LoginResponse;
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
            // Wrap response in LoginResponse DTO — avoids exposing the hashed password field
            LoginResponse loginResponse = new LoginResponse(
                    null, // Token generation not implemented in this project scope
                    authenticatedUser.getUsername(),
                    authenticatedUser.getRole(),
                    authenticatedUser.getName()
            );
            return new ApiResponse("success", "Login successful! Welcome back, " + authenticatedUser.getName(), loginResponse);
        } else {
            return new ApiResponse("fail", "Invalid username or password combinations.", null);
        }
    }
}
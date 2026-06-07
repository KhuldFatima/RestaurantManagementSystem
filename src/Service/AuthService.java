package Service;

import Model.User;
import Repository.UserRepository;

public class AuthService {
    private final UserRepository userRepository = new UserRepository();

    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
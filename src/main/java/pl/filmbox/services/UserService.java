package pl.filmbox.services;

import pl.filmbox.models.User;

import java.util.List;

public interface UserService {
    User addUser(User user, List<Long> credits);
    User updateUser(User user, List<Long> credits);
    User getUser(Long userId);
    List<User> getAllUsers();
    void deleteUser(User user);
}

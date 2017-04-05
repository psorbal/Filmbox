package pl.filmbox.services;

import pl.filmbox.models.User;

import java.util.List;

public interface UserService {
    User addAndUpdateUser(User user, List<Long> credits);
    User getUser(Long userId);
    List<User> getAllUsers();
    void deleteUser(User user);
}

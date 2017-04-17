package pl.filmbox.repositories;

import pl.filmbox.models.User;

import java.util.List;

public interface UserRepository {
    User addAndUpdateUser(User user);
    User getUser(Long userId);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void deleteUser(User user);
}

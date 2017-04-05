package pl.filmbox.repositories;

import pl.filmbox.models.User;

import java.util.List;

public interface UserRepository {
    User addAndUpdateUser(User user);
    User getUser(Long userId);
    List<User> getAllUsers();
    void deleteUser(User user);
}

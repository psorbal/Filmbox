package pl.filmbox.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.filmbox.models.User;
import pl.filmbox.repositories.UserRepository;
import pl.filmbox.services.CreditService;
import pl.filmbox.services.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private CreditService creditService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            CreditService creditService,
            BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.creditService = creditService;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User addUser(User user, List<Long> credits) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        for (Long creditId : credits) {
            user.addCredit(creditService.getCredit(creditId));
        }
        return userRepository.addAndUpdateUser(user);
    }

    @Override
    public User updateUser(User user, List<Long> credits) {
        for (Long creditId : credits) {
            user.addCredit(creditService.getCredit(creditId));
        }
        return userRepository.addAndUpdateUser(user);
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.getUser(userId);
        user.getCredits().size();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        for (User user : userList) {
            user.getCredits().size();
        }
        return userList;
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }
}

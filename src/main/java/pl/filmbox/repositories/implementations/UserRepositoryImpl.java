package pl.filmbox.repositories.implementations;

import org.springframework.stereotype.Repository;
import pl.filmbox.models.User;
import pl.filmbox.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User addAndUpdateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getUser(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;

        try{
            TypedQuery<User> typedQuery = entityManager.createQuery(
                    "SELECT u FROM "+ User.class.getSimpleName() +" u where u.username = :username",
                    User.class
            );
            typedQuery.setParameter("username", username);
            user = typedQuery.getSingleResult();
        }
        catch (NoResultException nre) {
            //do nothing
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;

        try{
            TypedQuery<User> typedQuery = entityManager.createQuery(
                    "SELECT u FROM "+ User.class.getSimpleName() +" u where u.email = :email",
                    User.class
            );
            typedQuery.setParameter("email", email);
            user = typedQuery.getSingleResult();
        }
        catch (NoResultException nre) {
            //do nothing
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> typedQuery = entityManager.createQuery(
                "SELECT u from " + User.class.getSimpleName() + " u",
                User.class
        );
        return typedQuery.getResultList();
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(
                entityManager.contains(user) ? user : entityManager.merge(user)
        );
    }
}
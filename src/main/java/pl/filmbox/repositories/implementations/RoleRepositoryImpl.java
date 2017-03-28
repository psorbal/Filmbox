package pl.filmbox.repositories.implementations;

import org.springframework.stereotype.Repository;
import pl.filmbox.models.Role;
import pl.filmbox.repositories.RoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role updateRole(Role role) {
        return entityManager.merge(role);
    }

    @Override
    public Role getRole(Long roleId) {
        return entityManager.find(Role.class, roleId);
    }

    @Override
    public List<Role> getAllRoles() {
        TypedQuery<Role> typedQuery = entityManager.createQuery(
                "SELECT r FROM " + Role.class.getSimpleName() + " r",
                Role.class
        );
        return typedQuery.getResultList();
    }

    @Override
    public void deleteRole(Long roleId) {
        Role role = entityManager.find(Role.class, roleId);
        if (role != null) {
            entityManager.remove(role);
        }
    }
}

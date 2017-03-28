package pl.filmbox.repositories;

import pl.filmbox.models.Role;
import java.util.List;

public interface RoleRepository {
    void addRole(Role role);
    Role updateRole(Role role);
    Role getRole(Long roleId);
    List<Role> getAllRoles();
    void deleteRole(Long roleId);
}

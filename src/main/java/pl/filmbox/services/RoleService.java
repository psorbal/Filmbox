package pl.filmbox.services;

import pl.filmbox.models.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    Role updateRole(Role role);

    Role getRole(Long roleId);

    List<Role> getAllRoles();

    void deleteRole(Long roleId);

}

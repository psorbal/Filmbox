package pl.filmbox.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.filmbox.models.Role;
import pl.filmbox.repositories.RoleRepository;
import pl.filmbox.services.RoleService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepository.addRole(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.updateRole(role);
    }

    @Override
    public Role getRole(Long roleId) {
        return roleRepository.getRole(roleId);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    @Override
    public void deleteRole(Long roleId) {
        roleRepository.deleteRole(roleId);
    }
}

package pl.filmbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.filmbox.models.Role;
import pl.filmbox.services.RoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public ModelAndView getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return new ModelAndView("roles/show-all", "roles", roles);
    }

    @GetMapping("/{id}")
    public ModelAndView getSingleRole(@PathVariable Long id) {
        Role role = roleService.getRole(id);
        return new ModelAndView("roles/show-single", "role", role);
    }

    @GetMapping("/create")
    public ModelAndView getCreateRoleForm() {
        return new ModelAndView("roles/create", "Role", new Role());
    }

    @PostMapping("/create")
    public ModelAndView createRole(@ModelAttribute Role role) {
        roleService.addRole(role);
        return new ModelAndView("redirect:/role/all");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditRoleForm(@PathVariable Long id) {
        Role role = roleService.getRole(id);
        return new ModelAndView("roles/edit", "role", role);
    }

    @PutMapping("/update")
    public ModelAndView updateRole(@ModelAttribute Role role) {
        roleService.updateRole(role);
        return new ModelAndView("redirect:/role/all");
    }

    @DeleteMapping("/delete/{id}")
    public ModelAndView deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return new ModelAndView("redirect:/role/all");
    }
}

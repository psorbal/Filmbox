package pl.filmbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.filmbox.models.User;
import pl.filmbox.services.CreditService;
import pl.filmbox.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private CreditService creditService;

    @Autowired
    public UserController(UserService userService, CreditService creditService) {
        this.userService = userService;
        this.creditService = creditService;
    }

    @GetMapping("/all")
    public ModelAndView getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ModelAndView("users/show-all", "users", users);
    }

    @GetMapping("/{id}")
    public ModelAndView getSingleUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return new ModelAndView("users/show-single", "user", user);
    }

    @GetMapping("/create")
    public ModelAndView getCreateUserForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.addObject("credits", creditService.getAllCredits());
        modelAndView.setViewName("users/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createUser(
            @ModelAttribute User user,
            @RequestParam("credits") List<Long> credits) {

        User user1 = userService.addUser(user, credits);
        return new ModelAndView("redirect:/user/"+user1.getId().toString());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditUserForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.getUser(id));
        modelAndView.addObject("credits", creditService.getAllCredits());
        modelAndView.setViewName("users/edit");
        return modelAndView;
    }

    @PutMapping("/update")
    public ModelAndView updateUser(
            @ModelAttribute User user,
            @RequestParam("credits") List<Long> credits) {

        userService.updateUser(user, credits);
        return new ModelAndView("redirect:/user/all");
    }

    @DeleteMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        userService.deleteUser(user);
        return new ModelAndView("redirect:/user/all");
    }
}

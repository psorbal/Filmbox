package pl.filmbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.filmbox.models.User;
import pl.filmbox.services.UserService;
import pl.filmbox.validators.UserValidation;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthController {

    private UserService userService;
    private UserValidation userValidation;

    @Autowired
    public AuthController(UserService userService, UserValidation userValidation) {
        this.userService = userService;
        this.userValidation = userValidation;
    }

    @GetMapping("/login")
    public String getLoginForm(Model model, String error) {

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid");

        return "auth/login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }

        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, BindingResult bindingResult) {

        userValidation.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }

        List<Long> credits = new ArrayList<>();
        credits.add(2L);
        userService.addUser(user, credits);

        return "redirect:/login";
    }
}

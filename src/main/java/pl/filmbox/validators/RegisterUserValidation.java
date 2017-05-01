package pl.filmbox.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.filmbox.models.User;
import pl.filmbox.services.UserService;

@Component
public class RegisterUserValidation implements Validator {

    private static final String EMAIL_PATTERN =
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    private final UserService userService;

    @Autowired
    public RegisterUserValidation(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.notEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "username.size");
        }
        if (userService.getUserByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "username.duplicate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.notEmpty");
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "password.size");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.notEmpty");
        if (user.getEmail().matches(EMAIL_PATTERN)) {
            errors.rejectValue("email", "email.regex");
        }
        if (userService.getUserByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "email.duplicate");
        }
    }
}

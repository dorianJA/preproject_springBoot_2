package ru.jm.springboot2.springboot2.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.jm.springboot2.springboot2.model.User;
import ru.jm.springboot2.springboot2.service.UserService;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if(userService.getUserByName(user.getUsername())!=null){
            errors.rejectValue("name","","This user already exists");
        }
    }
}

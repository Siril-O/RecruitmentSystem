package ua.recruitment.system.web.controller.user;

import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.service.user.UserService;
import ua.recruitment.system.web.controller.user.converter.UserConverter;
import ua.recruitment.system.web.dto.CreateUserRequest;
import ua.recruitment.system.web.response.UserDto;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Controller
@RequestMapping("/user")
@Secured(value = "isAuthenticated()")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserConverter userConverter;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> getUsers() {
        final List<User> users = userService.getAllUsers();
        return userConverter.convert(users);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void createApplicant(@RequestBody @Valid CreateUserRequest createUserDto) {
        userService.registerUser(createUserDto);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public UserDto loginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = new UserDto();
        userDto.setEmail(auth.getName());
        userDto.setUserRole(auth.getAuthorities().iterator().next().getAuthority());
        return userDto;
    }
}

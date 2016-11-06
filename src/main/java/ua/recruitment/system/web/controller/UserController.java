package ua.recruitment.system.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.recruitment.system.domain.User;
import ua.recruitment.system.repository.UserRepository;
import ua.recruitment.system.web.dto.CreateUserDto;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        return userRepository.getList(0, 100);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void createUser(@RequestBody @Valid CreateUserDto createUserDto){
        User user = new User();
        user.setName(createUserDto.getName());
        user.setEmail(createUserDto.getEmail());
        userRepository.create(user);
    }

    private User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("John Joe");
        user.setEmail("user@email.com");
        return user;
    }
}

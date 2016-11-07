package ua.recruitment.system.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.recruitment.system.domain.user.Applicant;
import ua.recruitment.system.domain.user.PersonInfo;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.UserRepository;
import ua.recruitment.system.service.UserService;
import ua.recruitment.system.web.controller.converter.UserConverter;
import ua.recruitment.system.web.dto.CreateUserDto;
import ua.recruitment.system.web.response.UserDto;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Controller
@RequestMapping("/user")
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
    public void createApplicant(@RequestBody @Valid CreateUserDto createUserDto) {
        Applicant user = new Applicant();
        PersonInfo personalInfo = new PersonInfo();
        personalInfo.setFirstName(createUserDto.getFirstName());
        personalInfo.setLastName(createUserDto.getLastName());
        personalInfo.setGender(createUserDto.getGender());
        user.setEmail(createUserDto.getEmail());
        user.setPersonInfo(personalInfo);
        userService.saveUser(user, createUserDto.getPassword());
    }
}

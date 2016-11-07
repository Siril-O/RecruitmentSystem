package ua.recruitment.system.web.controller;

import ua.recruitment.system.domain.user.Applicant;
import ua.recruitment.system.domain.user.PersonInfo;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.UserRepository;
import ua.recruitment.system.web.controller.converter.UserConverter;
import ua.recruitment.system.web.dto.CreateUserDto;
import ua.recruitment.system.web.response.UserDto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> getUsers() {
        final List<User> users = userRepository.getList(0, 100);
        return userConverter.convert(users);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void createApplicant(@RequestBody @Valid CreateUserDto createUserDto) {
        Applicant user = new Applicant();
        PersonInfo personalInfo = new PersonInfo();
        personalInfo.setFirstName(createUserDto.getName());
        user.setEmail(createUserDto.getEmail());
        user.setPersonInfo(personalInfo);
        userRepository.create(user);
    }
}

package ua.recruitment.system.facade.converter;

import ua.recruitment.system.domain.user.PersonInfo;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.web.controller.user.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * Created by Kyrylo_Kovalchuk on 11/7/2016.
 */
@Component
public class UserToDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(final User input) {
        return convert(input, new UserDto());
    }

    @Override
    public UserDto convert(final User user, final UserDto userDto) {
        final PersonInfo personInfo = user.getPersonInfo();
        userDto.setEmail(user.getEmail());
        if(personInfo != null) {
            userDto.setFirstName(personInfo.getFirstName());
            userDto.setLastName(personInfo.getLastName());
            userDto.setGender(user.getPersonInfo().getGender() != null ? user.getPersonInfo().getGender().toString() : null);
        }
        return userDto;
    }

    @Override
    public List<UserDto> convert(final List<User> input) {
        return input.stream().map(this::convert).collect(Collectors.toList());
    }
}

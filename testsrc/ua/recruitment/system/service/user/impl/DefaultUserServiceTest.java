package ua.recruitment.system.service.user.impl;

import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.UserRepository;
import ua.recruitment.system.service.user.UserFactory;
import ua.recruitment.system.web.dto.CreateUserRequest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultUserServiceTest {

    private static final String EMAIL = "johnDoe@gmail.com";
    private static final String USER_WITH_EMAIL_ALREADY_EXIST = "User with email:%s already exist";

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserFactory userFactory;

    @InjectMocks
    private DefaultUserService testingInstance = new DefaultUserService();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldNotRegisterUserWhenEmailIsExist() {
        when(userRepository.countByEmail(EMAIL)).thenReturn(1L);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(String.format(USER_WITH_EMAIL_ALREADY_EXIST, EMAIL));

        testingInstance.registerUser(givenUserRequest());
    }

    @Test

    public void shouldRegisterUser() {
        when(userRepository.countByEmail(EMAIL)).thenReturn(0L);

        final CreateUserRequest createUserRequest = givenUserRequest();
        testingInstance.registerUser(createUserRequest);

        verify(userFactory).createUser(createUserRequest);
        verify(userRepository).create(any(User.class));
    }

    private CreateUserRequest givenUserRequest() {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setEmail(EMAIL);
        return userRequest;
    }
}
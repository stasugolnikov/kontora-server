package ru.itmo.kontora.server.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itmo.kontora.server.BaseTest;
import ru.itmo.kontora.server.dto.UserDto;
import ru.itmo.kontora.server.exception.NotAuthorizedException;
import ru.itmo.kontora.server.mapper.UserMapper;
import ru.itmo.kontora.server.model.User;
import ru.itmo.kontora.server.repository.RoleRepository;
import ru.itmo.kontora.server.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest extends BaseTest {

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleRepository roleRepository;

    private List<Long> userIdsToRemove;


    @BeforeEach
    void setUp() {
        userIdsToRemove = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAllById(userIdsToRemove);
    }

    @Test
    void RegistrationTeacher() {
        UserDto userDto = new UserDto();
        userDto.setFullName("user");
        userDto.setPassword("password");
        userDto = userService.register(userDto);
        assertTrue(userRepository.existsById(userDto.getId()));
        User user1 = userRepository.findById(userDto.getId()).orElseThrow();
        assertEquals(user1.getFullName(), userDto.getFullName());
        assertEquals(userDto.getUsername(), user1.getUsername());
        assertTrue(bCryptPasswordEncoder.matches("password", user1.getPassword()));
        userIdsToRemove.add(user1.getId());
    }

    @Test
    void checkUserSuccessful() {
        UserDto userDto = new UserDto();
        userDto.setUsername("admin");
        userDto.setPassword("password");
        userService.checkUser(userDto);
    }

    @Test
    void checkUserNotAuthorized() {
        UserDto userDto = new UserDto();
        userDto.setUsername("admin");
        userDto.setPassword("bad password");

        NotAuthorizedException ex = assertThrows(NotAuthorizedException.class, () -> userService.checkUser(userDto));
        assertEquals("User not authorized", ex.getMessage());
    }

    @Test
    void loadUserByUsernameSuccessful() {
        assertEquals("admin", userService.loadUserByUsername("admin").getUsername());
    }

    @Test
    void loadUserByUsernameWhenTeacherDoesNotExist() {
        UsernameNotFoundException exception = assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("bad name"));
        assertEquals("Not found Teacher with username: bad name", exception.getMessage());
    }


}
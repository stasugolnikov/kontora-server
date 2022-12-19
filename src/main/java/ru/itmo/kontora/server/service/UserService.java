package ru.itmo.kontora.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itmo.kontora.server.dto.UserDto;
import ru.itmo.kontora.server.exception.NotAuthorizedException;
import ru.itmo.kontora.server.mapper.UserMapper;
import ru.itmo.kontora.server.model.User;
import ru.itmo.kontora.server.repository.UserRepository;
import ru.itmo.kontora.server.security.UserDetailsImpl;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserDto register(UserDto userDto) {
        User user = userMapper.fromDto(userDto);
        user.setRole(roleService.getByName("USER"));
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user = userRepository.save(user);
        return userMapper.fromEntity(user);

    }

    public UserDto checkUser(UserDto userDto) {
        UserDetails user = loadUserByUsername(userDto.getUsername());
        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new NotAuthorizedException("User not authorized");
        }
        return userDto;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException(String.format("Not found Teacher with username: %s", username));
                });
        return new UserDetailsImpl(user);
    }

}



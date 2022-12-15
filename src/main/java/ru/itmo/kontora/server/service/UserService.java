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

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

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
        if (passwordEncoder.encode(userDto.getPassword()).equals(user.getPassword())) {
            throw new NotAuthorizedException("User not authorized");
        }
        return userDto;
    }

    public User findById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Teacher not found by id=" + id);
                });
    }

    public UserDto getById(Long id) {
        return userMapper.fromEntity(findById(id));
    }

    @Transactional
    public List<UserDto> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::fromEntity)
                .toList();
    }

    @Transactional
    public UserDto update(Long id, UserDto userDto) {
        User user = findById(id);
        user.setFullName(userDto.getFullName());
        user = userRepository.save(user);
        return userMapper.fromEntity(user);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Not found Teacher with username: " + username);
                });
        return new UserDetailsImpl(user);
    }

}



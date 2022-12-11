package ru.itmo.kontora.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.kontora.server.model.Role;
import ru.itmo.kontora.server.repository.RoleRepository;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Not found role: " + name);
                });
    }
}


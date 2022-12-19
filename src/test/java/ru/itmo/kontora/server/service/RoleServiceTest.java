package ru.itmo.kontora.server.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itmo.kontora.server.BaseTest;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoleServiceTest extends BaseTest {

    @Autowired
    private RoleService roleService;

    @Test
    void getRoleByNameSuccessful() {
        assertEquals("ADMIN", roleService.getByName("ADMIN").getName());
    }

    @Test
    void getRoleByNameWhenRoleDoesNotExist() {
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> roleService.getByName("NEWROLE"));
        assertEquals("Not found role: " + "NEWROLE", exception.getMessage());
    }

}
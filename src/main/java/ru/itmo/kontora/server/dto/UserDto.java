package ru.itmo.kontora.server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String fullName;
    private String username;
    private String password;
    private RoleDto roleDto;
}

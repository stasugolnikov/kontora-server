package ru.itmo.kontora.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itmo.kontora.server.dto.UserDto;
import ru.itmo.kontora.server.model.User;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "roleDto", source = "role")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    UserDto fromEntity(User user);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "role", source = "roleDto")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    User fromDto(UserDto userDto);



}

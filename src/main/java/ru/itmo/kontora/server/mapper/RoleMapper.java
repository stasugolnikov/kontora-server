package ru.itmo.kontora.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itmo.kontora.server.dto.RoleDto;
import ru.itmo.kontora.server.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    Role fromDto(RoleDto roleDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    RoleDto fromEntity(Role role);
}


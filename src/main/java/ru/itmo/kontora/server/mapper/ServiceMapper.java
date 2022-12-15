package ru.itmo.kontora.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itmo.kontora.server.dto.ServiceDto;
import ru.itmo.kontora.server.model.Service;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    Service fromDto(ServiceDto serviceDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ServiceDto fromEntity(Service service);
}

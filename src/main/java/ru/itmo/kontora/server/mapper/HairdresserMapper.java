package ru.itmo.kontora.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itmo.kontora.server.dto.HairdresserDto;
import ru.itmo.kontora.server.model.Hairdresser;

@Mapper(componentModel = "spring")
public interface HairdresserMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "description", source = "description")
    Hairdresser fromDto(HairdresserDto hairdresserDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "description", source = "description")
    HairdresserDto fromEntity(Hairdresser hairdresser);

}

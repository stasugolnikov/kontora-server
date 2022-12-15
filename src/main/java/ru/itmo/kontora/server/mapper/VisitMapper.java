package ru.itmo.kontora.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itmo.kontora.server.dto.VisitDto;
import ru.itmo.kontora.server.model.Visit;

@Mapper(componentModel = "spring")
public interface VisitMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "serviceInfoId", source = "serviceInfoId")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "date", source = "date")
    Visit fromDto(VisitDto visitDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "serviceInfoId", source = "serviceInfoId")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "date", source = "date")
    VisitDto fromEntity(Visit visit);
}

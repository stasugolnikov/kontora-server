package ru.itmo.kontora.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itmo.kontora.server.dto.ServiceInfoDto;
import ru.itmo.kontora.server.model.ServiceInfo;

@Mapper(componentModel = "spring", uses = {ServiceMapper.class, HairdresserMapper.class})
public interface ServiceInfoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "service", source = "serviceDto")
    @Mapping(target = "hairdresser", source = "hairdresserDto")
    ServiceInfo fromDto(ServiceInfoDto serviceInfoDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "serviceDto", source = "service")
    @Mapping(target = "hairdresserDto", source = "hairdresser")
    ServiceInfoDto fromEntity(ServiceInfo serviceInfo);
}

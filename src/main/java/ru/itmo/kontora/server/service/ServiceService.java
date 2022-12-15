package ru.itmo.kontora.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.kontora.server.dto.ServiceDto;
import ru.itmo.kontora.server.dto.ServiceInfoDto;
import ru.itmo.kontora.server.mapper.ServiceInfoMapper;
import ru.itmo.kontora.server.mapper.ServiceMapper;
import ru.itmo.kontora.server.repository.ServiceInfoRepository;
import ru.itmo.kontora.server.repository.ServiceRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    @Transactional
    public List<ServiceDto> getAll() {
        return serviceRepository
                .findAll()
                .stream()
                .map(serviceMapper::fromEntity)
                .toList();
    }
}

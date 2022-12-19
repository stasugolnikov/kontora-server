package ru.itmo.kontora.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.kontora.server.dto.ServiceInfoDto;
import ru.itmo.kontora.server.mapper.ServiceInfoMapper;
import ru.itmo.kontora.server.repository.ServiceInfoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceInfoService {
    private final ServiceInfoRepository serviceInfoRepository;
    private final ServiceInfoMapper serviceInfoMapper;

    @Transactional
    public List<ServiceInfoDto> getAll() {
        return serviceInfoRepository
                .findAll()
                .stream()
                .map(serviceInfoMapper::fromEntity)
                .toList();
    }
}

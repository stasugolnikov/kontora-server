package ru.itmo.kontora.server.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itmo.kontora.server.BaseTest;
import ru.itmo.kontora.server.dto.ServiceInfoDto;
import ru.itmo.kontora.server.mapper.ServiceInfoMapper;
import ru.itmo.kontora.server.repository.ServiceInfoRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceInfoServiceTest extends BaseTest {
    @Autowired
    ServiceInfoService serviceInfoService;
    @Autowired
    ServiceInfoRepository serviceInfoRepository;
    @Autowired
    ServiceInfoMapper serviceInfoMapper;
    private ServiceInfoDto serviceInfoDto;

    @Test
    void getAllTest() {

        List<ServiceInfoDto> serviceInfoDtos = new ArrayList<>();
        for (long i = 1; i < 5; i++) {
            serviceInfoDto = new ServiceInfoDto();
            serviceInfoDto.setId(i);
            serviceInfoDtos.add(serviceInfoDto);
        }

        List<ServiceInfoDto> answer = serviceInfoService.getAll();

        assertEquals(serviceInfoDtos, answer);
    }

}
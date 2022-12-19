package ru.itmo.kontora.server.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itmo.kontora.server.BaseTest;
import ru.itmo.kontora.server.dto.ServiceDto;
import ru.itmo.kontora.server.mapper.ServiceMapper;
import ru.itmo.kontora.server.repository.ServiceRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceServiceTest extends BaseTest {
    @Autowired
    ServiceService serviceService;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    ServiceMapper serviceMapper;
    private ServiceDto serviceDto;

    @Test
    void getAllTest() {

        List<ServiceDto> serviceDtos = new ArrayList<>();
        for (long i = 1; i < 5; i++) {
            serviceDto = new ServiceDto();
            serviceDto.setId(i);
            serviceDtos.add(serviceDto);
        }

        List<ServiceDto> answer = serviceService.getAll();

        assertEquals(serviceDtos, answer);
    }

}
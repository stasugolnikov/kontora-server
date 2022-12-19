package ru.itmo.kontora.server.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itmo.kontora.server.BaseTest;
import ru.itmo.kontora.server.dto.HairdresserDto;
import ru.itmo.kontora.server.mapper.HairdresserMapper;
import ru.itmo.kontora.server.repository.HairdresserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HairdresserServiceTest extends BaseTest {

    @Autowired
    HairdresserService hairdresserService;
    @Autowired
    HairdresserRepository hairdresserRepository;
    @Autowired
    HairdresserMapper hairdresserMapper;
    private HairdresserDto hairdresserDto;

    @Test
    void getAllTest() {

        List<HairdresserDto> hairdressers = new ArrayList<>();
        for (long i = 1; i < 5; i++) {
            hairdresserDto = new HairdresserDto();
            hairdresserDto.setId(i);
            hairdressers.add(hairdresserDto);
        }

        List<HairdresserDto> answer = hairdresserService.getAll();

        assertEquals(hairdressers, answer);
    }
}
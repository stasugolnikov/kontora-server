package ru.itmo.kontora.server.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itmo.kontora.server.BaseTest;
import ru.itmo.kontora.server.dto.VisitDto;
import ru.itmo.kontora.server.mapper.VisitMapper;
import ru.itmo.kontora.server.model.Visit;
import ru.itmo.kontora.server.repository.VisitRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VisitServiceTest extends BaseTest {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitService visitService;

    @Autowired
    private VisitMapper visitMapper;

    private Visit visit;


    private List<Long> visitIdsToRemove;

    @BeforeEach
    void setUp() {
        visitIdsToRemove = new ArrayList<>();
        visit = new Visit();
        visit.setComment("comment");
        visit.setServiceInfoId(1L);
        visit.setUserId(1L);
        visit.setDate(Timestamp.valueOf("2022-11-10 10:00:00"));
        visit = visitRepository.save(visit);
        visitIdsToRemove.add(visit.getId());
    }

    @AfterEach
    void tearDown() {
        visitRepository.deleteAllById(visitIdsToRemove);
    }

    @Test
    void addLesson() {
        VisitDto visitDto = new VisitDto();
        visitDto.setComment("comment");
        visitDto.setServiceInfoId(1L);
        visitDto.setUserId(1L);
        visitDto.setDate(Timestamp.valueOf("2022-11-10 10:00:00"));
        visitDto = visitService.create(visitDto);
        assertTrue(visitRepository.existsById(visitDto.getId()));
        Visit visit1 = visitRepository.findById(visitDto.getId()).orElseThrow();
        assertEquals(visitDto.getId(), visit1.getId());
        assertEquals(visitDto.getDate(), visit1.getDate());
        assertEquals(visitDto.getComment(), visit1.getComment());
        assertEquals(visitDto.getUserId(), visit1.getUserId());
        assertEquals(visitDto.getServiceInfoId(), visit1.getServiceInfoId());
        visitIdsToRemove.add(visitDto.getId());
    }

    @Test
    void findVisitsByUserId() {
        assertEquals(List.of(visit), visitService.findByUserId(visit.getUserId()));
    }

    @Test
    void getVisitsByUserId() {
        assertEquals(List.of(visitMapper.fromEntity(visit)), visitService.getByUserId(visit.getUserId()));
    }

}
package ru.itmo.kontora.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.kontora.server.dto.VisitDto;
import ru.itmo.kontora.server.mapper.VisitMapper;
import ru.itmo.kontora.server.model.Visit;
import ru.itmo.kontora.server.repository.VisitRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;


    public VisitDto create(VisitDto visitDto) {
        return visitMapper.fromEntity(visitRepository.save(visitMapper.fromDto(visitDto)));
    }

    public List<Visit> findByUserId(Long userId) {
        return visitRepository
                .findByUserId(userId);
    }

    public List<VisitDto> getByUserId(Long userId) {
        return findByUserId(userId).stream().map(visitMapper::fromEntity).toList();
    }

}

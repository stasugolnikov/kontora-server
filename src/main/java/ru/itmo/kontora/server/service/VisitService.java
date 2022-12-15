package ru.itmo.kontora.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.kontora.server.dto.UserDto;
import ru.itmo.kontora.server.dto.VisitDto;
import ru.itmo.kontora.server.mapper.VisitMapper;
import ru.itmo.kontora.server.model.User;
import ru.itmo.kontora.server.model.Visit;
import ru.itmo.kontora.server.repository.VisitRepository;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;


    public VisitDto create(VisitDto visitDto) {
        return visitMapper.fromEntity(visitRepository.save(visitMapper.fromDto(visitDto)));

    }

    public Visit findByUserId(Long userId) {
        return visitRepository
                .findByUserId(userId)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Visit not found by user id=" + userId);
                });
    }

    public VisitDto getByUserId(Long userId) {
        return visitMapper.fromEntity(findByUserId(userId));
    }

}

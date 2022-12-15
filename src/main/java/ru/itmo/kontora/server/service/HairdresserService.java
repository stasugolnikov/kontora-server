package ru.itmo.kontora.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.kontora.server.dto.HairdresserDto;
import ru.itmo.kontora.server.mapper.HairdresserMapper;
import ru.itmo.kontora.server.repository.HairdresserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HairdresserService {

    private final HairdresserRepository hairdresserRepository;
    private final HairdresserMapper hairdresserMapper;

    @Transactional
    public List<HairdresserDto> getAll() {
        return hairdresserRepository
                .findAll()
                .stream()
                .map(hairdresserMapper::fromEntity)
                .toList();
    }
}

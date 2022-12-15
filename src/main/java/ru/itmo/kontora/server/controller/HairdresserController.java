package ru.itmo.kontora.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.kontora.server.dto.HairdresserDto;
import ru.itmo.kontora.server.service.HairdresserService;

import java.util.List;

@RestController
@RequestMapping("hairdresser")
@RequiredArgsConstructor
public class HairdresserController {

    private final HairdresserService hairdresserService;

    @GetMapping("get-all")
    public List<HairdresserDto> getAll() {
        return hairdresserService.getAll();
    }
}

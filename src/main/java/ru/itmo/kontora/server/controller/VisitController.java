package ru.itmo.kontora.server.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.kontora.server.dto.VisitDto;
import ru.itmo.kontora.server.service.VisitService;

import java.util.List;

@RestController
@RequestMapping("visit")
@RequiredArgsConstructor
public class VisitController {
    private final VisitService service;

    @PostMapping
    public VisitDto create(@RequestBody VisitDto visitDto) {
        return service.create(visitDto);
    }

    @GetMapping("get-all/{userId}")
    public List<VisitDto> getByUserId(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }
}

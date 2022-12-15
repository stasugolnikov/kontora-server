package ru.itmo.kontora.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.kontora.server.dto.ServiceDto;
import ru.itmo.kontora.server.service.ServiceService;

import java.util.List;

@RestController
@RequestMapping("service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService service;

    @GetMapping("get-all")
    public List<ServiceDto> getAll() {
        return service.getAll();
    }
}

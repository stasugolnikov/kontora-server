package ru.itmo.kontora.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.kontora.server.dto.ServiceInfoDto;
import ru.itmo.kontora.server.service.ServiceInfoService;

import java.util.List;

@RestController
@RequestMapping("service-info")
@RequiredArgsConstructor
public class ServiceInfoController {
    private final ServiceInfoService service;

    @GetMapping("get-all")
    public List<ServiceInfoDto> getAll() {
        return service.getAll();
    }
}

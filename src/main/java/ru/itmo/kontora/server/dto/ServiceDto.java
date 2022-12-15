package ru.itmo.kontora.server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceDto {
    private Long id;
    private String name;
}

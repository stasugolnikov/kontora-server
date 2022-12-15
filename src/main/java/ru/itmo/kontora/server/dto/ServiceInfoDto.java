package ru.itmo.kontora.server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceInfoDto {
    private Long id;
    private Long price;
    private ServiceDto serviceDto;
    private HairdresserDto hairdresserDto;
}

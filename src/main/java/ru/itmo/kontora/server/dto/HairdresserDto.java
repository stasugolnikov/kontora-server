package ru.itmo.kontora.server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HairdresserDto {
    private Long id;
    private String fullName;
    private String phone;
    private String description;
}

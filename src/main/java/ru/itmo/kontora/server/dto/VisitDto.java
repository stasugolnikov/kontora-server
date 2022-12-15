package ru.itmo.kontora.server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class VisitDto {
    private Long id;
    private Long userId;
    private Long serviceInfoId;
    private String comment;
    private Timestamp date;
}

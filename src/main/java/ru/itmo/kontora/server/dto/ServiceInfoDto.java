package ru.itmo.kontora.server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class ServiceInfoDto {
    private Long id;
    private Long price;
    private ServiceDto serviceDto;
    private HairdresserDto hairdresserDto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceInfoDto that = (ServiceInfoDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

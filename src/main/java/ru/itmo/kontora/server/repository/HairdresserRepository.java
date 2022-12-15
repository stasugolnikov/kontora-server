package ru.itmo.kontora.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.kontora.server.model.Hairdresser;

@Repository
public interface HairdresserRepository extends JpaRepository<Hairdresser, Long> {
}

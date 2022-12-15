package ru.itmo.kontora.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.kontora.server.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}

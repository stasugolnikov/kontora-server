package ru.itmo.kontora.server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "visit", schema = "kontora_schema")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "service_info_id")
    private Long serviceInfoId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private Timestamp date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return id.equals(visit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

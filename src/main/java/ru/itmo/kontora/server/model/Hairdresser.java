package ru.itmo.kontora.server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "hairdresser", schema = "kontora_schema")
public class Hairdresser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "hairdresser", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private Set<ServiceInfo> serviceInfos = new HashSet<>();
}

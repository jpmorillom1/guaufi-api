package com.kj.guaufi_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.locationtech.jts.geom.Polygon;

import java.util.UUID;

@Entity
@Table(name="service_areas")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ServiceArea {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="walker_id", nullable = false)
    private WalkerProfile walker;

    @NotNull
    @Column(nullable = false, columnDefinition = "geography(Polygon,4326)")
    private Polygon area;

    private String label;
}
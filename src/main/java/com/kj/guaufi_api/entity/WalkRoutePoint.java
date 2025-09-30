package com.kj.guaufi_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="walk_route_points",
        uniqueConstraints = @UniqueConstraint(name="ux_walk_seq", columnNames={"walk_id","seq"}))
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WalkRoutePoint {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="walk_id", nullable = false)
    private Walk walk;

    @NotNull
    @Column(nullable = false)
    private OffsetDateTime ts;

    @NotNull
    @Column(nullable = false, columnDefinition = "geography(Point,4326)")
    private Point geom;

    private BigDecimal altitude;
    private BigDecimal speedMps;
    private BigDecimal accuracyM;

    @NotNull @Min(0) @Column(nullable = false)
    private Integer seq;
}
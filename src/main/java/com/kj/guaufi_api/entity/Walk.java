package com.kj.guaufi_api.entity;

import com.kj.guaufi_api.enums.WalkStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.locationtech.jts.geom.LineString;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name="walks")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Walk {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="booking_id", nullable = false)
    private Booking booking;

    private OffsetDateTime actualStart;
    private OffsetDateTime actualEnd;

    private BigDecimal distanceKm;
    private Integer steps;

    @Column(columnDefinition = "geography(LineString,4326)")
    private LineString route;

    private String routePolyline;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> routeSummary;

    @Enumerated(EnumType.STRING)
    private WalkStatus status;
}
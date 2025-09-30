package com.kj.guaufi_api.entity;

import com.kj.guaufi_api.enums.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="bookings")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="client_id", nullable = false)
    private ClientProfile client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="walker_id", nullable = false)
    private WalkerProfile walker;

    @NotNull
    @Column(nullable = false)
    private OffsetDateTime scheduledStart;

    @NotNull @Min(1) @Column(nullable = false)
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status = BookingStatus.REQUESTED;

    private BigDecimal priceQuote;

    @Column(columnDefinition = "geography(Point,4326)")
    private Point locationStart;

    @Column(columnDefinition = "geography(Point,4326)")
    private Point locationEnd;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cancelled_by_user_id")
    private User cancelledBy;

    private String cancelReason;
}
package com.kj.guaufi_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name="walker_availability")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WalkerAvailability {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="walker_id", nullable = false)
    private WalkerProfile walker;

    @NotNull
    @Min(0) @Max(6) @Column(nullable = false)
    private Integer dow;

    @NotNull @Column(nullable = false)
    private LocalTime startTime;
    @NotNull @Column(nullable = false)
    private LocalTime endTime;
}
package com.kj.guaufi_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="booking_dogs")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(BookingDog.PK.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BookingDog {

    @Id @EqualsAndHashCode.Include
    @NotNull
    @Column(name="booking_id", nullable = false)
    private UUID bookingId;

    @Id @EqualsAndHashCode.Include
    @NotNull @Column(name="dog_id", nullable = false)
    private UUID dogId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="booking_id", insertable=false, updatable=false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dog_id", insertable=false, updatable=false)
    private Dog dog;

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class PK implements Serializable {
        private UUID bookingId;
        private UUID dogId;
    }
}
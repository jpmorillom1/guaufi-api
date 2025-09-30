package com.kj.guaufi_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;

@Entity
@Table(
        name="reviews",
        uniqueConstraints = @UniqueConstraint(name="ux_reviewer_booking", columnNames={"reviewer_user_id","booking_id"})
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Review  {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="reviewer_user_id", nullable = false)
    private User reviewer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="reviewee_user_id", nullable = false)
    private User reviewee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="booking_id", nullable = false)
    private Booking booking;

    @NotNull
    @Min(1) @Max(5) @Column(nullable = false)
    private Integer rating;

    private String comment;
}
package com.kj.guaufi_api.entity;

import com.kj.guaufi_api.enums.WalkEventType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;


@Entity
@Table(name="walk_events")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WalkEvent {

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
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WalkEventType type;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> payload;
}
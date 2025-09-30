package com.kj.guaufi_api.entity;

import com.kj.guaufi_api.enums.DogSize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;


@Entity
@Table(name="dogs")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dog {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="owner_client_id", nullable = false)
    private ClientProfile owner;

    @NotBlank
    @Column(nullable = false)
    private String name;

    private String breed;

    @Enumerated(EnumType.STRING)
    private DogSize size;

    @Min(0)
    private Integer ageYears;

    private String notes;

    @NotNull
    @Column(nullable = false)
    private Boolean active = true;
}
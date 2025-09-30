package com.kj.guaufi_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.UUID;



@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Email @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    @NotBlank @Column(nullable = false)
    private String passwordHash;

    @NotBlank @Column(nullable = false)
    private String firstName;
    @NotBlank @Column(nullable = false)
    private String lastName;

    private String avatarUrl;

    @Column(nullable = false)
    private Boolean active = true;
}
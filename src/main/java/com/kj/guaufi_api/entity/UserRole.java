package com.kj.guaufi_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="user_roles")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(UserRole.PK.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserRole {

    @Id @Column(nullable=false)
    @EqualsAndHashCode.Include
    private UUID userId;

    @Id @Column(nullable=false)
    @EqualsAndHashCode.Include
    @NotBlank
    private String role; // CLIENT, WALKER, ADMIN

    @Column(nullable=false)
    private OffsetDateTime grantedAt = OffsetDateTime.now();

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class PK implements Serializable {
        private UUID userId;
        private String role;
    }
}
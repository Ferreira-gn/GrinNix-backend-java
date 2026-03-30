package com.ferreira_gn.grannix.model.persistence.entity;

import com.ferreira_gn.grannix.model.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@Table(name = "user_table")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public void update(UserEntity infoToUpdate) {
        if (infoToUpdate.getUsername() != null) this.username = infoToUpdate.getUsername();
        if (infoToUpdate.getEmail() != null) this.email = infoToUpdate.getEmail();
    }
}

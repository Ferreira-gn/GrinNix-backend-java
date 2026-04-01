package com.ferreira_gn.grannix.model.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private ProblemsEntity problem;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguagesEntity language;


    private String status;

    @Column(name = "runtime_ms")
    Integer runtimeMs;

    @Builder.Default
    @Column(name = "is_public")
    Boolean isPublic = true;

    @Builder.Default
    @CreationTimestamp
    @Column(name = "submitted_at")
    private LocalDateTime submittedAt = LocalDateTime.now();

    public void update(SubmissionsEntity infoToUpdate) {
        if (infoToUpdate.getCode() != null) this.code = infoToUpdate.getCode();
    }
}

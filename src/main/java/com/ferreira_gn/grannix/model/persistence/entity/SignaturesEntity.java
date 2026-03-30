package com.ferreira_gn.grannix.model.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Entity
@Table(name = "signatures_table")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignaturesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String signature;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguagesEntity language;

    @OneToOne
    @JoinColumn(name = "problem_id")
    private ProblemsEntity problem;

    public void update(SignaturesEntity infoToUpdate) {
        if (infoToUpdate.getSignature() != null) this.signature = infoToUpdate.getSignature();
    }
}

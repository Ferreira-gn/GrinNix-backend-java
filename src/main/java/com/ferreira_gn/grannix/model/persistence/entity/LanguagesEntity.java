package com.ferreira_gn.grannix.model.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Table(name = "languages_table")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 20)
    private String version;

    @Builder.Default
    @Column(name = "is_active")
    private Boolean isActive = true;

    public void update(LanguagesEntity infoToUpdate) {
        if (infoToUpdate.getName() != null) this.name = infoToUpdate.getName();
        if (infoToUpdate.getVersion() != null) this.version = infoToUpdate.getVersion();
        if (infoToUpdate.getIsActive() != null) this.isActive = infoToUpdate.getIsActive();
    }
}

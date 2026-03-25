package com.ferreira_gn.grannix.database.entity;

import com.ferreira_gn.grannix.database.enums.DifficultyEnum;
import com.ferreira_gn.grannix.dto.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.dto.problems.ProblemsDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.Instant;
import java.util.UUID;

@Entity
public class ProblemsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "title", nullable = false, length = 255)
  private String title;

  @Column(name = "description", nullable = false, length = 10000)
  private String description;

  @Enumerated(EnumType.STRING)
  private DifficultyEnum difficulty;

  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  @PrePersist
  public void prePersist() {
    this.createdAt = Instant.now();
    this.updatedAt = Instant.now();
  }

  @PreUpdate
  public void preUpdate() {
    this.updatedAt = Instant.now();
  }

  protected ProblemsEntity() {}

  public static ProblemsEntity fromDTO(CreateProblemsRequestDTO dto) {
    ProblemsEntity entity = new ProblemsEntity();
    entity.title = dto.title();
    entity.description = dto.description();
    entity.difficulty = dto.difficulty();
    return entity;
  }

  public static ProblemsDTO toDTO(ProblemsEntity entity) {
    return new ProblemsDTO(
      entity.id,
      entity.title,
      entity.description,
      entity.difficulty
    );
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DifficultyEnum getDificulty() {
    return difficulty;
  }

  public void setDifficulty(DifficultyEnum dificulty) {
    this.difficulty = dificulty;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }
}

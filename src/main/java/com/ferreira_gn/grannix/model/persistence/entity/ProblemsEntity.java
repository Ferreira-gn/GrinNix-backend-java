package com.ferreira_gn.grannix.model.persistence.entity;

import com.ferreira_gn.grannix.model.domain.enums.DifficultyEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@Table(name = "problems_table")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description", nullable = false, length = 10000)
  private String description;

  @Enumerated(EnumType.STRING)
  private DifficultyEnum difficulty;

  @Builder.Default
  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @OneToOne(mappedBy = "problem")
  private SignaturesEntity signature;

  public void update(ProblemsEntity infoToUpdate) {
    if (infoToUpdate.getTitle() != null) this.setTitle(infoToUpdate.getTitle());
    if (infoToUpdate.getDescription() != null) this.setDescription(infoToUpdate.getDescription());
    if (infoToUpdate.getDifficulty() != null) this.setDifficulty(infoToUpdate.getDifficulty());
    }
}

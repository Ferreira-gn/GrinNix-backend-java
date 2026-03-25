package com.ferreira_gn.grannix.dto.problems;

import com.ferreira_gn.grannix.database.enums.DifficultyEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateProblemsRequestDTO(
  @NotBlank(message = "Title is required")
  @Size(
    min = 5,
    max = 100,
    message = "Title must be between 5 and 100 characters"
  )
  String title,

  @NotBlank(message = "Description is required")
  @Size(
    min = 100,
    max = 10000,
    message = "Description must be between 100 and 10000 characters"
  )
  String description,

  @NotNull(message = "Difficulty is required") DifficultyEnum difficulty
) {}

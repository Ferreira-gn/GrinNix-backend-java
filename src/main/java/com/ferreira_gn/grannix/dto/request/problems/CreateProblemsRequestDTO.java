package com.ferreira_gn.grannix.dto.request.problems;

import com.ferreira_gn.grannix.domain.enums.DifficultyEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateProblemsRequestDTO(
  @NotNull(message = "Title is required")
  @NotBlank(message = "Title is required")
  @Size(
    min = 5,
    max = 100,
    message = "Title must be between 5 and 100 characters"
  )
  String title,

  @NotNull(message = "Description is required")
  @NotBlank(message = "Description is required")
  @Size(
    min = 100,
    max = 10000,
    message = "Description must be between 100 and 10000 characters"
  )
  String description,

  DifficultyEnum difficulty
) {}

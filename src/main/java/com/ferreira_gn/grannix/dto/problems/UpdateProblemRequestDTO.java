package com.ferreira_gn.grannix.dto.problems;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;

public record UpdateProblemRequestDTO(
  @Nullable
  @Size(
    min = 5,
    max = 100,
    message = "Title must be between 5 and 100 characters"
  )
  String title,

  @Nullable
  @Size(
    min = 100,
    max = 10000,
    message = "Description must be between 100 and 10000 characters"
  )
  String description,

  @Nullable String difficulty
) {}

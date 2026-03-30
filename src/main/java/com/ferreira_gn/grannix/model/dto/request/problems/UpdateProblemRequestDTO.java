package com.ferreira_gn.grannix.model.dto.request.problems;

import com.ferreira_gn.grannix.model.domain.enums.DifficultyEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateProblemRequestDTO(
  @NotNull(message = "Tittle cannot be null")
  @Size(
    min = 5,
    max = 100,
    message = "Title must be between 5 and 100 characters"
  )
  String title,

  @NotNull(message = "Description cannot be null")
  @Size(
    min = 100,
    max = 10000,
    message = "Description must be between 100 and 10000 characters"
  )
  String description,


  DifficultyEnum difficulty
) {}

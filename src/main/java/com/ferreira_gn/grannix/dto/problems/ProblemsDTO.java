package com.ferreira_gn.grannix.dto.problems;

import com.ferreira_gn.grannix.database.enums.DifficultyEnum;
import java.util.UUID;

public record ProblemsDTO(
  UUID id,
  String title,
  String description,
  DifficultyEnum difficulty
) {}

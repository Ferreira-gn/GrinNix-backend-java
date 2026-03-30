package com.ferreira_gn.grannix.model.dto.response.problems;

import com.ferreira_gn.grannix.model.domain.enums.DifficultyEnum;
import java.util.UUID;

public record ProblemsResponseDTO(
  UUID id,
  String title,
  String description,
  DifficultyEnum difficulty,
  ProblemsSignatureResponseDTO signature
) {}

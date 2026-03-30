package com.ferreira_gn.grannix.model.dto.response.signatures;

import com.ferreira_gn.grannix.model.domain.enums.DifficultyEnum;

import java.util.UUID;

public record SignaturesProblemsResponseDTO(
        UUID id,
        String title,
        String description,
        DifficultyEnum difficulty
) {
}

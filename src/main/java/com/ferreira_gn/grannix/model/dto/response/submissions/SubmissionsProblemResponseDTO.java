package com.ferreira_gn.grannix.model.dto.response.submissions;

import com.ferreira_gn.grannix.model.domain.enums.DifficultyEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record SubmissionsProblemResponseDTO(
        UUID id,
        String title,
        String description,
        DifficultyEnum difficulty,
        LocalDateTime createdAt
) {
}

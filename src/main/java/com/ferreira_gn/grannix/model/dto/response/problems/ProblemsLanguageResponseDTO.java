package com.ferreira_gn.grannix.model.dto.response.problems;

import java.util.UUID;

public record ProblemsLanguageResponseDTO(
        UUID id,
        String name,
        String version,
        Boolean isActive
) {
}

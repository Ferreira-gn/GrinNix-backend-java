package com.ferreira_gn.grannix.model.dto.response.problems;

import java.util.UUID;

public record ProblemsSignatureResponseDTO(
        UUID id,
        String signature,
        ProblemsLanguageResponseDTO language
) {
}

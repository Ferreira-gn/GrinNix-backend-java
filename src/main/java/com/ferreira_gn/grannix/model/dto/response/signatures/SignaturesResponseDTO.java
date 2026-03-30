package com.ferreira_gn.grannix.model.dto.response.signatures;

import java.util.UUID;

public record SignaturesResponseDTO(
    UUID id,
    String signature,
    SignaturesLanguageResponseDTO language,
    SignaturesProblemsResponseDTO problem
) {
}

package com.ferreira_gn.grannix.model.dto.response.signatures;

import java.util.UUID;

public record SignaturesLanguageResponseDTO(
        UUID id,
        String name,
        String version,
        Boolean isActive
) {
}

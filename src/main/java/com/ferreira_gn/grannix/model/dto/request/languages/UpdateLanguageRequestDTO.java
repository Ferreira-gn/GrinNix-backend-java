package com.ferreira_gn.grannix.model.dto.request.languages;

public record UpdateLanguageRequestDTO(
        String name,
        String version,
        Boolean isActive
) {
}

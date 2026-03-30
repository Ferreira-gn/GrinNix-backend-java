package com.ferreira_gn.grannix.model.dto.response.languages;


import java.util.UUID;

public record LanguageResponseDTO (
        UUID id,
        String name,
        String version,
        Boolean isActive
) {}

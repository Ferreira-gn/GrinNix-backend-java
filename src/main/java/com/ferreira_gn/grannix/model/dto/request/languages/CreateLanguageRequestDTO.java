package com.ferreira_gn.grannix.model.dto.request.languages;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateLanguageRequestDTO (
        @NotNull(message = "name cannot be null")
        @NotBlank(message = "name cannot be blank")
        String name,

        @NotNull(message = "version cannot be null")
        @NotBlank(message = "version cannot be blank")
        String version,

        @NotNull(message = "isActive cannot be null")
        Boolean isActive
) {
}

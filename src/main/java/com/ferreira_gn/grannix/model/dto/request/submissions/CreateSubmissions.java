package com.ferreira_gn.grannix.model.dto.request.submissions;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSubmissions(
        @NotNull(message = "code cannot be null")
        @NotBlank(message = "code cannot be blank")
        String code,

        @NotNull(message = "status cannot be null")
        @NotBlank(message = "status cannot be blank")
        String status,

        @NotNull(message = "runtimeMs cannot be null")
        @NotBlank(message = "runtimeMs cannot be blank")
        Integer runtimeMs
) {
}

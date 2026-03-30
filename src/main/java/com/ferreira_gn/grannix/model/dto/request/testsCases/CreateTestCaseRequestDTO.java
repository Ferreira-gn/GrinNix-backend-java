package com.ferreira_gn.grannix.model.dto.request.testsCases;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTestCaseRequestDTO (
        @NotNull(message = "Input cannot be null")
        @NotBlank(message = "Input cannot be blank")
        String input,

        @NotNull(message = "expectedOutput cannot be null")
        @NotBlank(message = "expectedOutput cannot be blank")
        String expectedOutput,

        @NotNull(message = "isHidden cannot be null")
        @NotBlank(message = "isHidden cannot be blank")
        Boolean isHidden,

        @NotNull(message = "testCaseExemple cannot be null")
        @NotBlank(message = "testCaseExemple cannot be blank")
        String testCaseExemple
) {
}

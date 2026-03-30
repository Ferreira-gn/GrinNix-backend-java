package com.ferreira_gn.grannix.model.dto.request.testsCases;

import jakarta.validation.constraints.NotBlank;

public record UpdateTestsCasesRequestDTO(
        @NotBlank(message = "Input cannot be blank")
        String input,

        @NotBlank(message = "expectedOutput cannot be blank")
        String expectedOutput,

        @NotBlank(message = "isHidden cannot be blank")
        Boolean isHidden,

        @NotBlank(message = "testCaseExemple cannot be blank")
        String testCaseExemple
) {
}

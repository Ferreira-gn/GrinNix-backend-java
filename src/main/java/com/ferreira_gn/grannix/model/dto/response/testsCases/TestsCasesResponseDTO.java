package com.ferreira_gn.grannix.model.dto.response.testsCases;

import java.util.UUID;

public record TestsCasesResponseDTO(
        UUID id,
        String input,
        String expectedOutput,
        Boolean isHidden,
        String testCaseExemple
) {
}

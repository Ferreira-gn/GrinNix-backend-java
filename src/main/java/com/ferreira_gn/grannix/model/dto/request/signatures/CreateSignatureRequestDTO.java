package com.ferreira_gn.grannix.model.dto.request.signatures;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSignatureRequestDTO(
        @NotNull(message = "signature cannot be null")
        @NotBlank(message = "signature cannot be blank")
        String signature
) {
}

package com.ferreira_gn.grannix.model.dto.request.submissions;

import jakarta.validation.constraints.NotBlank;

public record UpdateSubmissionRequestDTO(
        @NotBlank(message = "code cannot be blank")
        String code
) {
}

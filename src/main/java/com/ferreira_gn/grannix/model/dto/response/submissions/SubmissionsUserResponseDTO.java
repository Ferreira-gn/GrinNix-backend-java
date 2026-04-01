package com.ferreira_gn.grannix.model.dto.response.submissions;

import java.util.UUID;

public record SubmissionsUserResponseDTO(
        UUID id,
        String username,
        String email
) {
}

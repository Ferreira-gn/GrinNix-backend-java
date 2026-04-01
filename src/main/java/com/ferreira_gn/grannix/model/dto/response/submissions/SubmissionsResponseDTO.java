package com.ferreira_gn.grannix.model.dto.response.submissions;

import java.util.UUID;

public record SubmissionsResponseDTO(
    UUID id,
    String code,
    SubmissionsUserResponseDTO user,
    SubmissionsProblemResponseDTO problem,
    String status,
    Integer runtimeMs,
    Boolean isPublic,
    String submittedAt
) {
}

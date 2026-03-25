package com.ferreira_gn.grannix.dto.error;

import java.time.Instant;

public record ErrorResponseDTO(int status, String message, Instant timestamp) {}

package com.ferreira_gn.grannix.model.dto.response.users;

import com.ferreira_gn.grannix.model.domain.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String username,
        String email,
        String password,
        Role role,
        LocalDateTime createdAt
) {
}

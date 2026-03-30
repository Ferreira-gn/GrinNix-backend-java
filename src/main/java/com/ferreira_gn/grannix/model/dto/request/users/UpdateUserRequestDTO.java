package com.ferreira_gn.grannix.model.dto.request.users;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequestDTO(
        @NotBlank(message = "username cannot be blank")
        String username,

        @NotBlank(message = "username cannot be blank")
        String email
) {
}

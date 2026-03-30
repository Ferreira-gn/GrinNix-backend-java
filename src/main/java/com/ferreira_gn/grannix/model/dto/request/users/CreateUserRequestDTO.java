package com.ferreira_gn.grannix.model.dto.request.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequestDTO(
        @NotNull(message = "username cannot be null")
        @NotBlank(message = "username cannot be blank")
        String username,

        @NotNull(message = "email cannot be null")
        @NotBlank(message = "email cannot be blank")
        String email,

        @NotNull(message = "password cannot be null")
        @NotBlank(message = "password cannot be blank")
        String password
) {
}

package com.ferreira_gn.grannix.controller;

import com.ferreira_gn.grannix.model.dto.request.users.CreateUserRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.users.UpdateUserRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.users.UserResponseDTO;
import com.ferreira_gn.grannix.model.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(
  origins = "http://localhost:5173",
  methods = {
    RequestMethod.GET,
    RequestMethod.DELETE,
    RequestMethod.PUT,
    RequestMethod.POST,
    RequestMethod.PATCH,
  },
  allowCredentials = "true",
  maxAge = 3600
)
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid CreateUserRequestDTO request) {
            return ResponseEntity.ok(userService.register(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> fetchUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.fetch(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable UUID userId,
            @RequestBody @Valid UpdateUserRequestDTO request
    ) {
        return ResponseEntity.ok(userService.update(userId, request));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
}

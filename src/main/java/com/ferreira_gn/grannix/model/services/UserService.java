package com.ferreira_gn.grannix.model.services;

import com.ferreira_gn.grannix.model.domain.enums.Role;
import com.ferreira_gn.grannix.model.domain.exception.EmailAlreadyExistsException;
import com.ferreira_gn.grannix.model.domain.exception.UserNotFoundException;
import com.ferreira_gn.grannix.model.dto.request.users.CreateUserRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.users.UpdateUserRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.users.UserResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.UserEntity;
import com.ferreira_gn.grannix.model.persistence.mappers.UserMapper;
import com.ferreira_gn.grannix.model.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDTO register(CreateUserRequestDTO request) {
        UserEntity preSaved = userMapper.map(request);

        preSaved.setPassword(BCrypt.hashpw(preSaved.getPassword(), BCrypt.gensalt()));
        preSaved.setRole(Role.STUDENT);

        return userMapper.map(userRepository.save(preSaved));
    }

    public UserResponseDTO fetch(UUID userId) {
        return userMapper.map(this.findEntity(userId));
    }

    public UserResponseDTO update(UUID userId, UpdateUserRequestDTO request) {
        UserEntity userFound = this.findEntity(userId);

        UserEntity infoToUpdate = userMapper.map(request);

        if (!userFound.getEmail().equals(infoToUpdate.getEmail()) && userRepository.existsUserByEmail(infoToUpdate.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        userFound.update(infoToUpdate);

        return userMapper.map(userRepository.save(userFound));
    }

    public void delete(UUID userId) {
        UserEntity userFound = this.findEntity(userId);
        userRepository.delete(userFound);
    }

    private UserEntity findEntity(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}

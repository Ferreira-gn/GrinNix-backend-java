package com.ferreira_gn.grannix.model.persistence.mappers;

import com.ferreira_gn.grannix.model.dto.request.users.CreateUserRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.users.UpdateUserRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.users.UserResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder =@Builder(disableBuilder = true))
public interface UserMapper {
    UserEntity map(CreateUserRequestDTO request);
    UserEntity map(UpdateUserRequestDTO request);

    UserResponseDTO map(UserEntity entity);
}

package com.ferreira_gn.grannix.model.persistence.mappers;

import com.ferreira_gn.grannix.model.dto.request.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.problems.UpdateProblemRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.problems.ProblemsResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.ProblemsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ProblemsMapper {
    ProblemsEntity map(CreateProblemsRequestDTO request);
    ProblemsEntity map(UpdateProblemRequestDTO request);
    ProblemsResponseDTO map(ProblemsEntity entity);
}

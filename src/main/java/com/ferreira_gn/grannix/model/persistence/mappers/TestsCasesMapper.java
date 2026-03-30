package com.ferreira_gn.grannix.model.persistence.mappers;

import com.ferreira_gn.grannix.model.dto.request.testsCases.CreateTestCaseRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.testsCases.UpdateTestsCasesRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.testsCases.TestsCasesResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.TestsCasesEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TestsCasesMapper {
    TestsCasesEntity map(CreateTestCaseRequestDTO request);
    TestsCasesEntity map(UpdateTestsCasesRequestDTO request);

    TestsCasesResponseDTO map(TestsCasesEntity entity);
}

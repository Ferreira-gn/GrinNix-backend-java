package com.ferreira_gn.grannix.model.persistence.mappers;

import com.ferreira_gn.grannix.model.dto.request.submissions.CreateSubmissions;
import com.ferreira_gn.grannix.model.dto.request.submissions.UpdateSubmissionRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.submissions.SubmissionsResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.SubmissionsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface SubmissionsMapper {
    SubmissionsEntity map(CreateSubmissions request);
    SubmissionsEntity map(UpdateSubmissionRequestDTO request);

    SubmissionsResponseDTO map(SubmissionsEntity entity);
}

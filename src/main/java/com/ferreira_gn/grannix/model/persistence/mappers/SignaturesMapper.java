package com.ferreira_gn.grannix.model.persistence.mappers;

import com.ferreira_gn.grannix.model.dto.request.signatures.CreateSignatureRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.signatures.UpdateSignatureRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.signatures.SignaturesResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.SignaturesEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface SignaturesMapper {
    SignaturesEntity map(CreateSignatureRequestDTO request);
    SignaturesEntity map(UpdateSignatureRequestDTO request);

    SignaturesResponseDTO map(SignaturesEntity request);
}

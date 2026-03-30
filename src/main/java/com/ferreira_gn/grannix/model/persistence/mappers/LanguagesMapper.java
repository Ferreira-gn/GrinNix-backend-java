package com.ferreira_gn.grannix.model.persistence.mappers;

import com.ferreira_gn.grannix.model.dto.request.languages.UpdateLanguageRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.languages.CreateLanguageRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.languages.LanguageResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.LanguagesEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LanguagesMapper {
    LanguagesEntity map(CreateLanguageRequestDTO request);
    LanguagesEntity map(UpdateLanguageRequestDTO request);

    LanguageResponseDTO map(LanguagesEntity entity);
}
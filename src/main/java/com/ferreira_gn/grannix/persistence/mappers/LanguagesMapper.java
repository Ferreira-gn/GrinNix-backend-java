package com.ferreira_gn.grannix.persistence.mappers;

import com.ferreira_gn.grannix.dto.request.languages.UpdateLanguageRequestDTO;
import com.ferreira_gn.grannix.dto.request.languages.CreateLanguageRequestDTO;
import com.ferreira_gn.grannix.dto.response.languages.LanguageResponseDTO;
import com.ferreira_gn.grannix.persistence.entity.LanguagesEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LanguagesMapper {
    LanguagesEntity map(CreateLanguageRequestDTO request);
    LanguagesEntity map(UpdateLanguageRequestDTO request);

    LanguageResponseDTO map(LanguagesEntity entity);
}
package com.ferreira_gn.grannix.model.services;

import com.ferreira_gn.grannix.model.domain.exception.LanguageNotFoundException;
import com.ferreira_gn.grannix.model.dto.request.languages.UpdateLanguageRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.languages.CreateLanguageRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.languages.LanguageResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.LanguagesEntity;
import com.ferreira_gn.grannix.model.persistence.mappers.LanguagesMapper;
import com.ferreira_gn.grannix.model.persistence.repositories.LanguagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LanguagesService {
    private final LanguagesRepository languagesRepository;
    private final LanguagesMapper languagesMapper;

    public LanguageResponseDTO register(CreateLanguageRequestDTO request) {
        LanguagesEntity preSaved = languagesMapper.map(request);
        return languagesMapper.map(languagesRepository.save(preSaved));
    }

    public LanguageResponseDTO fetch(UUID languageId) {
        return languagesMapper.map(this.findEntity(languageId));
    }

    public List<LanguageResponseDTO> list() {
        return languagesRepository.findAll()
                .stream()
                .map(languagesMapper::map)
                .toList();
    }

    public LanguageResponseDTO update(UUID languageId, UpdateLanguageRequestDTO request) {
        LanguagesEntity languageFound = this.findEntity(languageId);

        LanguagesEntity infoToUpdate = languagesMapper.map(request);

        languageFound.update(infoToUpdate);

        return languagesMapper.map(languagesRepository.save(languageFound));
    }

    public void delete(UUID languageId) {
        LanguagesEntity languageFound = this.findEntity(languageId);
        languagesRepository.delete(languageFound);
    }

    private LanguagesEntity findEntity(UUID languageId) {
        return languagesRepository.findById(languageId)
                .orElseThrow(LanguageNotFoundException::new);
    }
}

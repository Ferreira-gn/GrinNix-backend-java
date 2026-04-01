package com.ferreira_gn.grannix.model.services;

import com.ferreira_gn.grannix.model.domain.exception.LanguageNotFoundException;
import com.ferreira_gn.grannix.model.domain.exception.ProblemNotFoundException;
import com.ferreira_gn.grannix.model.domain.exception.SignatureNotFoundException;
import com.ferreira_gn.grannix.model.dto.request.signatures.CreateSignatureRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.signatures.UpdateSignatureRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.signatures.SignaturesResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.LanguagesEntity;
import com.ferreira_gn.grannix.model.persistence.entity.ProblemsEntity;
import com.ferreira_gn.grannix.model.persistence.entity.SignaturesEntity;
import com.ferreira_gn.grannix.model.persistence.mappers.SignaturesMapper;
import com.ferreira_gn.grannix.model.persistence.repositories.LanguagesRepository;
import com.ferreira_gn.grannix.model.persistence.repositories.ProblemsRepository;
import com.ferreira_gn.grannix.model.persistence.repositories.SignaturesRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SignaturesService {
    private final SignaturesRepository signaturesRepository;
    private final LanguagesRepository languagesRepository;
    private final ProblemsRepository problemsRepository;
    private final SignaturesMapper signaturesMapper;

    public SignaturesResponseDTO register(UUID languageId, UUID problemId, CreateSignatureRequestDTO request) {
        LanguagesEntity languageFound = languagesRepository.findById(languageId)
                .orElseThrow(LanguageNotFoundException::new);

        ProblemsEntity problemFound = problemsRepository.findById(problemId)
                .orElseThrow(ProblemNotFoundException::new);

        SignaturesEntity preSaved = signaturesMapper.map(request);

        preSaved.setLanguage(languageFound);
        preSaved.setProblem(problemFound);

        return signaturesMapper.map(signaturesRepository.save(preSaved));
    }

    public SignaturesResponseDTO fetch(UUID signatureId) {
        return signaturesMapper.map(this.findEntity(signatureId));
    }

    public SignaturesResponseDTO fetch(UUID languageId, UUID problemId) {
        SignaturesEntity signatureFound = signaturesRepository.findByLanguageIdAndProblemId(languageId, problemId)
                .orElseThrow(SignatureNotFoundException::new);
        return signaturesMapper.map(signatureFound);
    }

    public List<SignaturesResponseDTO> list() {
        return signaturesRepository.findAll()
                .stream()
                .map(signaturesMapper::map)
                .toList();
    }

    public SignaturesResponseDTO update(UUID signatureId, @Valid UpdateSignatureRequestDTO request) {
        SignaturesEntity signatureFound = this.findEntity(signatureId);

        SignaturesEntity infoToUpdate = signaturesMapper.map(request);

        signatureFound.update(infoToUpdate);

        return signaturesMapper.map(signaturesRepository.save(signatureFound));
    }

    public void delete(UUID signatureId) {
        SignaturesEntity signatureFound = this.findEntity(signatureId);
        signaturesRepository.delete(signatureFound);
    }

    private SignaturesEntity findEntity(UUID signatureId) {
        return signaturesRepository.findById(signatureId)
                .orElseThrow(SignatureNotFoundException::new);
    }
}

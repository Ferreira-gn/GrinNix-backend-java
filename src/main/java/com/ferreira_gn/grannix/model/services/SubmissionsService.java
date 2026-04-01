package com.ferreira_gn.grannix.model.services;

import com.ferreira_gn.grannix.model.domain.exception.LanguageNotFoundException;
import com.ferreira_gn.grannix.model.domain.exception.ProblemNotFoundException;
import com.ferreira_gn.grannix.model.domain.exception.SubmissionNotFoundException;
import com.ferreira_gn.grannix.model.domain.exception.UserNotFoundException;
import com.ferreira_gn.grannix.model.dto.request.submissions.CreateSubmissions;
import com.ferreira_gn.grannix.model.dto.request.submissions.UpdateSubmissionRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.submissions.SubmissionsResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.LanguagesEntity;
import com.ferreira_gn.grannix.model.persistence.entity.ProblemsEntity;
import com.ferreira_gn.grannix.model.persistence.entity.SubmissionsEntity;
import com.ferreira_gn.grannix.model.persistence.entity.UserEntity;
import com.ferreira_gn.grannix.model.persistence.mappers.SubmissionsMapper;
import com.ferreira_gn.grannix.model.persistence.repositories.LanguagesRepository;
import com.ferreira_gn.grannix.model.persistence.repositories.ProblemsRepository;
import com.ferreira_gn.grannix.model.persistence.repositories.SubmissionsRepository;
import com.ferreira_gn.grannix.model.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubmissionsService {
    private final SubmissionsRepository submissionsRepository;
    private final UserRepository userRepository;
    private final ProblemsRepository problemsRepository;
    private final LanguagesRepository languagesRepository;
    private final SubmissionsMapper submissionsMapper;

    public SubmissionsResponseDTO register(UUID userId, UUID problemId, UUID languageId, CreateSubmissions request) {
        UserEntity userFound = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        ProblemsEntity problemFound = problemsRepository.findById(problemId)
                .orElseThrow(ProblemNotFoundException::new);


        LanguagesEntity languageFound = languagesRepository.findById(languageId)
                .orElseThrow(LanguageNotFoundException::new);


        SubmissionsEntity preSaved = submissionsMapper.map(request);
        preSaved.setUser(userFound);
        preSaved.setProblem(problemFound);
        preSaved.setLanguage(languageFound);

        return submissionsMapper.map(submissionsRepository.save(preSaved));
    }

    public SubmissionsResponseDTO fetch(UUID submissionId) {
        return submissionsMapper.map(this.findEntity(submissionId));
    }


    public List<SubmissionsResponseDTO> list() {
        return submissionsRepository.findAll()
                .stream()
                .map(submissionsMapper::map)
                .toList();
    }

    public SubmissionsResponseDTO update(UUID submissionId, UpdateSubmissionRequestDTO request) {
        SubmissionsEntity submissionFound = this.findEntity(submissionId);

        SubmissionsEntity infoToUpdate = submissionsMapper.map(request);

        submissionFound.update(infoToUpdate);

        return submissionsMapper.map(submissionsRepository.save(submissionFound));
    }


    public void delete(UUID submissionId) {
        SubmissionsEntity submissionFound = this.findEntity(submissionId);
        submissionsRepository.delete(submissionFound);
    }

    private SubmissionsEntity findEntity(UUID submissionId) {
        return submissionsRepository.findById(submissionId)
                .orElseThrow(SubmissionNotFoundException::new);
    }
}

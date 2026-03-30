package com.ferreira_gn.grannix.services;

import com.ferreira_gn.grannix.domain.exception.ProblemNotFoundException;
import com.ferreira_gn.grannix.dto.request.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.dto.request.problems.UpdateProblemRequestDTO;
import com.ferreira_gn.grannix.dto.response.problems.ProblemsResponseDTO;
import com.ferreira_gn.grannix.persistence.entity.ProblemsEntity;
import com.ferreira_gn.grannix.persistence.mappers.ProblemsMapper;
import com.ferreira_gn.grannix.persistence.repositories.ProblemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProblemsService {
    private final ProblemsMapper problemsMapper;
    private final ProblemsRepository problemsRepository;

    public ProblemsResponseDTO register(CreateProblemsRequestDTO request) {
        ProblemsEntity preSaved = problemsMapper.map(request);
        return problemsMapper.map(problemsRepository.save(preSaved));
    }

    public ProblemsResponseDTO fetch(UUID problemId) {
        return problemsMapper.map(this.findEntity(problemId));
    }

    public ProblemsResponseDTO update(UUID problemId, UpdateProblemRequestDTO request) {
        ProblemsEntity problemFound = this.findEntity(problemId);

        ProblemsEntity infoToUpdate = problemsMapper.map(request);

        problemFound.update(infoToUpdate);
        return problemsMapper.map(problemsRepository.save(problemFound));
    }

    public List<ProblemsResponseDTO> list() {
        return problemsRepository.findAll()
                .stream()
                .map(problemsMapper::map)
                .toList();
    }


    public void delete(UUID problemId) {
        ProblemsEntity problemFound = this.findEntity(problemId);
        problemsRepository.delete(problemFound);
    }

    private ProblemsEntity findEntity(UUID problemId) {
        return problemsRepository.findById(problemId)
                .orElseThrow(ProblemNotFoundException::new);
    }
}

package com.ferreira_gn.grannix.model.services;

import com.ferreira_gn.grannix.model.domain.exception.ProblemNotFoundException;
import com.ferreira_gn.grannix.model.domain.exception.TestsCasesNotFoundException;
import com.ferreira_gn.grannix.model.dto.request.testsCases.CreateTestCaseRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.testsCases.UpdateTestsCasesRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.testsCases.TestsCasesResponseDTO;
import com.ferreira_gn.grannix.model.persistence.entity.ProblemsEntity;
import com.ferreira_gn.grannix.model.persistence.entity.TestsCasesEntity;
import com.ferreira_gn.grannix.model.persistence.mappers.TestsCasesMapper;
import com.ferreira_gn.grannix.model.persistence.repositories.ProblemsRepository;
import com.ferreira_gn.grannix.model.persistence.repositories.TestsCasesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestsCasesService {
    private final TestsCasesRepository testsCasesRepository;
    private final ProblemsRepository problemsRepository;
    private final TestsCasesMapper testsCasesMapper;

    public TestsCasesResponseDTO register(UUID problemId, CreateTestCaseRequestDTO request) {
        ProblemsEntity problemFound = problemsRepository.findById(problemId)
                .orElseThrow(ProblemNotFoundException::new);

        TestsCasesEntity preSaved = testsCasesMapper.map(request);

        preSaved.setProblem(problemFound);

        return testsCasesMapper.map(testsCasesRepository.save(preSaved));
    }

    public TestsCasesResponseDTO fetch(UUID testCaseId) {
        return testsCasesMapper.map(this.findEntity(testCaseId));
    }

    public List<TestsCasesResponseDTO> list() {
        return testsCasesRepository.findAll()
                .stream()
                .map(testsCasesMapper::map)
                .toList();
    }

    public TestsCasesResponseDTO update(UUID testCaseId, UpdateTestsCasesRequestDTO request) {
        TestsCasesEntity testCaseFound = this.findEntity(testCaseId);

        TestsCasesEntity infoToUpdate = testsCasesMapper.map(request);

        testCaseFound.update(infoToUpdate);

        return testsCasesMapper.map(testsCasesRepository.save(testCaseFound));
    }

    public void delete(UUID testCaseId) {
        TestsCasesEntity testCaseFound = this.findEntity(testCaseId);
        testsCasesRepository.delete(testCaseFound);
    }

    private TestsCasesEntity findEntity(UUID testCaseId) {
        return testsCasesRepository.findById(testCaseId)
                .orElseThrow(TestsCasesNotFoundException::new);
    }
}

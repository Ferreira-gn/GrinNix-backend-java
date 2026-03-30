package com.ferreira_gn.grannix.services;

import com.ferreira_gn.grannix.dto.request.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.dto.response.problems.ProblemsResponseDTO;
import com.ferreira_gn.grannix.dto.request.problems.UpdateProblemRequestDTO;
import com.ferreira_gn.grannix.persistence.entity.ProblemsEntity;
import com.ferreira_gn.grannix.domain.exception.ResourceNotFoundException;
import com.ferreira_gn.grannix.persistence.mappers.ProblemsMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Deprecated
@Service
@RequiredArgsConstructor
public class ProblemsModel {
  private final ProblemsMapper problemsMapper;

  @PersistenceContext
  private final EntityManager entityManager;

  @Transactional
  public boolean createProblem(CreateProblemsRequestDTO request) {
    try {
      ProblemsEntity preSaved = problemsMapper.map(request);
      entityManager.persist(preSaved);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Transactional
  public void updateProblem(UUID problemId, UpdateProblemRequestDTO request) {
    ProblemsEntity problemFound = entityManager.find(ProblemsEntity.class, problemId);

    if (problemFound == null) {
      throw new ResourceNotFoundException();
    }


    if (request.title() != null) problemFound.setTitle(request.title());
    if (request.description() != null) problemFound.setDescription(request.description());
    if (request.difficulty() != null) problemFound.setDifficulty(request.difficulty());
  }

  public List<ProblemsResponseDTO> listProblems() {
    return entityManager
      .createQuery("SELECT p FROM ProblemsEntity p", ProblemsEntity.class)
      .getResultList()
      .stream()
      .map(problemsMapper::map)
      .toList();
  }

  public ProblemsResponseDTO findProblemById(UUID problemId) {
    ProblemsEntity problemFound = entityManager.find(ProblemsEntity.class, problemId);

    if (problemFound == null) {
      throw new ResourceNotFoundException("The problem was not found.");
    }

    return problemsMapper.map(problemFound);
  }
}

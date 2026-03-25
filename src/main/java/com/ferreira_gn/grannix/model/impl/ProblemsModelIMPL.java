package com.ferreira_gn.grannix.model.impl;

import com.ferreira_gn.grannix.database.entity.ProblemsEntity;
import com.ferreira_gn.grannix.database.enums.DifficultyEnum;
import com.ferreira_gn.grannix.dto.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.dto.problems.ProblemsDTO;
import com.ferreira_gn.grannix.dto.problems.UpdateProblemRequestDTO;
import com.ferreira_gn.grannix.exception.errors.ResourceNotFoundException;
import com.ferreira_gn.grannix.model.interfaces.ProblemsModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ProblemsModelIMPL implements ProblemsModel {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  @Transactional
  public boolean createProblem(CreateProblemsRequestDTO problem) {
    try {
      entityManager.persist(ProblemsEntity.fromDTO(problem));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  @Transactional
  public void updateProblem(UUID id, UpdateProblemRequestDTO body) {
    ProblemsEntity probelm = entityManager.find(ProblemsEntity.class, id);

    if (probelm == null) {
      throw new ResourceNotFoundException("The problem was not found.");
    }

    if (body.title() != null) probelm.setTitle(body.title());
    if (body.description() != null) probelm.setDescription(body.description());
    if (body.difficulty() != null) probelm.setDifficulty(
      DifficultyEnum.valueOf(body.difficulty())
    );
  }

  @Override
  public List<ProblemsDTO> listProblems() {
    return entityManager
      .createQuery("SELECT p FROM ProblemsEntity p", ProblemsEntity.class)
      .getResultList()
      .stream()
      .map(item -> ProblemsEntity.toDTO(item))
      .toList();
  }

  @Override
  public ProblemsDTO findProblemById(UUID id) {
    ProblemsEntity entity = entityManager.find(ProblemsEntity.class, id);

    if (entity == null) {
      throw new ResourceNotFoundException("The problem was not found.");
    }

    return ProblemsEntity.toDTO(entity);
  }
}

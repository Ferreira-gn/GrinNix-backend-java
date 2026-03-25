package com.ferreira_gn.grannix.model.interfaces;

import com.ferreira_gn.grannix.dto.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.dto.problems.ProblemsDTO;
import com.ferreira_gn.grannix.dto.problems.UpdateProblemRequestDTO;
import java.util.List;
import java.util.UUID;

public interface ProblemsModel {
  boolean createProblem(CreateProblemsRequestDTO problem);
  void updateProblem(UUID id, UpdateProblemRequestDTO problem);
  List<ProblemsDTO> listProblems();
  ProblemsDTO findProblemById(UUID id);
}

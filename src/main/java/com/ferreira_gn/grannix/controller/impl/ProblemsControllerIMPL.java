package com.ferreira_gn.grannix.controller.impl;

import com.ferreira_gn.grannix.controller.interfaces.ProblemsController;
import com.ferreira_gn.grannix.dto.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.dto.problems.ProblemsDTO;
import com.ferreira_gn.grannix.dto.problems.UpdateProblemRequestDTO;
import com.ferreira_gn.grannix.model.interfaces.ProblemsModel;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/problems")
public class ProblemsControllerIMPL implements ProblemsController {

  private final ProblemsModel problemsModel;

  public ProblemsControllerIMPL(ProblemsModel model) {
    this.problemsModel = model;
  }

  @Override
  public ResponseEntity<String> createProblem(
    CreateProblemsRequestDTO requestBody
  ) {
    boolean created = problemsModel.createProblem(requestBody);

    if (created) {
      return ResponseEntity.ok("Problem created");
    }

    return ResponseEntity.badRequest().body("Problem creation failed");
  }

  @Override
  public ResponseEntity<List<ProblemsDTO>> getProblems() {
    List<ProblemsDTO> problemsList = problemsModel.listProblems();
    return ResponseEntity.ok(problemsList);
  }

  @Override
  public ResponseEntity<ProblemsDTO> getProblemsById(UUID id) {
    ProblemsDTO problem = problemsModel.findProblemById(id);
    return ResponseEntity.status(HttpStatus.OK).body(problem);
  }

  @Override
  public ResponseEntity<String> updateProblem(
    UUID id,
    UpdateProblemRequestDTO problem
  ) {
    problemsModel.updateProblem(id, problem);
    return ResponseEntity.ok("Problem updated");
  }
}

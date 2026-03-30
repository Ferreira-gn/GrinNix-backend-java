package com.ferreira_gn.grannix.controller;

import com.ferreira_gn.grannix.dto.request.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.dto.request.problems.UpdateProblemRequestDTO;
import com.ferreira_gn.grannix.dto.response.problems.ProblemsResponseDTO;
import com.ferreira_gn.grannix.services.ProblemsModel;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Deprecated
@RestController
@RequestMapping("/v1/problems")
public class ProblemsControllerDeprecated {

  private final ProblemsModel problemsModel;

  public ProblemsControllerDeprecated(ProblemsModel model) {
    this.problemsModel = model;
  }

  @PostMapping("")
  public ResponseEntity<String> createProblem(
    @RequestBody @Valid CreateProblemsRequestDTO requestBody
  ) {
    boolean created = problemsModel.createProblem(requestBody);

    if (created) {
      return ResponseEntity.ok("Problem created");
    }

    return ResponseEntity.badRequest().body("Problem creation failed");
  }

  @GetMapping("")
  public ResponseEntity<List<ProblemsResponseDTO>> getProblems() {
    List<ProblemsResponseDTO> problemsList = problemsModel.listProblems();
    return ResponseEntity.ok(problemsList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProblemsResponseDTO> getProblemsById(@PathVariable UUID id) {
    ProblemsResponseDTO problem = problemsModel.findProblemById(id);
    return ResponseEntity.status(HttpStatus.OK).body(problem);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<String> updateProblem(
    @PathVariable UUID id,
    @RequestBody @Valid UpdateProblemRequestDTO problem
  ) {
    problemsModel.updateProblem(id, problem);
    return ResponseEntity.ok("Problem updated");
  }
}

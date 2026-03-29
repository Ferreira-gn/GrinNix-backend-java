package com.ferreira_gn.grannix.controller;

import com.ferreira_gn.grannix.dto.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.dto.problems.ProblemsDTO;
import com.ferreira_gn.grannix.dto.problems.UpdateProblemRequestDTO;
import com.ferreira_gn.grannix.model.ProblemsModel;
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

@RestController
@RequestMapping("/v1/problems")
public class ProblemsController {

  private final ProblemsModel problemsModel;

  public ProblemsController(ProblemsModel model) {
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
  public ResponseEntity<List<ProblemsDTO>> getProblems() {
    List<ProblemsDTO> problemsList = problemsModel.listProblems();
    return ResponseEntity.ok(problemsList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProblemsDTO> getProblemsById(@PathVariable UUID id) {
    ProblemsDTO problem = problemsModel.findProblemById(id);
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

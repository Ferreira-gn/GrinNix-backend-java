package com.ferreira_gn.grannix.controller.interfaces;

import com.ferreira_gn.grannix.dto.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.dto.problems.ProblemsDTO;
import com.ferreira_gn.grannix.dto.problems.UpdateProblemRequestDTO;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProblemsController {
  @GetMapping("")
  ResponseEntity<List<ProblemsDTO>> getProblems();

  @GetMapping("/{id}")
  ResponseEntity<ProblemsDTO> getProblemsById(@PathVariable UUID id);

  @PostMapping("")
  ResponseEntity<String> createProblem(
    @RequestBody @Valid CreateProblemsRequestDTO requestBody
  );

  @PatchMapping("/{id}")
  ResponseEntity<String> updateProblem(
    @PathVariable UUID id,
    @RequestBody @Valid UpdateProblemRequestDTO problem
  );
}

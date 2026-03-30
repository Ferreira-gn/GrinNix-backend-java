package com.ferreira_gn.grannix.controller;

import com.ferreira_gn.grannix.model.dto.request.problems.CreateProblemsRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.problems.UpdateProblemRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.problems.ProblemsResponseDTO;
import com.ferreira_gn.grannix.model.services.ProblemsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/problems")
@RequiredArgsConstructor
public class ProblemsController {
    private final ProblemsService problemsService;

    @PostMapping
    public ResponseEntity<ProblemsResponseDTO> createProblem(@RequestBody @Valid CreateProblemsRequestDTO request) {
        return ResponseEntity.ok(problemsService.register(request));
    }

    @GetMapping("/{problemId}")
    public ResponseEntity<ProblemsResponseDTO> fetchProblem(@PathVariable UUID problemId) {
        return ResponseEntity.ok(problemsService.fetch(problemId));
    }

    @GetMapping
    public ResponseEntity<List<ProblemsResponseDTO>> listProblems() {
        return ResponseEntity.ok(problemsService.list());
    }

    @PutMapping("/{problemId}")
    public ResponseEntity<ProblemsResponseDTO> updateProblem(
            @PathVariable UUID problemId,
            @RequestBody @Valid UpdateProblemRequestDTO request
            ) {
        return ResponseEntity.ok(problemsService.update(problemId, request));
    }

    @DeleteMapping("/{problemId}")
    public ResponseEntity<Void> deleteProblem(@PathVariable UUID problemId) {
        problemsService.delete(problemId);
        return ResponseEntity.ok().build();
    }
}

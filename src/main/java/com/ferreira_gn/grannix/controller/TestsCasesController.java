package com.ferreira_gn.grannix.controller;

import com.ferreira_gn.grannix.model.dto.request.testsCases.CreateTestCaseRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.testsCases.UpdateTestsCasesRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.testsCases.TestsCasesResponseDTO;
import com.ferreira_gn.grannix.model.services.TestsCasesService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tests-cases")
@RequiredArgsConstructor
@CrossOrigin(
  origins = "http://localhost:5173",
  methods = {
    RequestMethod.GET,
    RequestMethod.DELETE,
    RequestMethod.PUT,
    RequestMethod.POST,
    RequestMethod.PATCH,
  },
  allowCredentials = "true",
  maxAge = 3600
)
public class TestsCasesController {

  private final TestsCasesService testsCasesService;

  @PostMapping("/problems/{problemId}")
  public ResponseEntity<TestsCasesResponseDTO> createTestCase(
    @PathVariable UUID problemId,
    @RequestBody @Valid CreateTestCaseRequestDTO request
  ) {
    return ResponseEntity.ok(testsCasesService.register(problemId, request));
  }

  @GetMapping("/{testCaseId}")
  public ResponseEntity<TestsCasesResponseDTO> fetchTestCase(
    @PathVariable UUID testCaseId
  ) {
    return ResponseEntity.ok(testsCasesService.fetch(testCaseId));
  }

  @GetMapping
  public ResponseEntity<List<TestsCasesResponseDTO>> listTestsCases() {
    return ResponseEntity.ok(testsCasesService.list());
  }

  @PutMapping("/{testCaseId}")
  public ResponseEntity<TestsCasesResponseDTO> updateTestCase(
    @PathVariable UUID testCaseId,
    @Valid @RequestBody UpdateTestsCasesRequestDTO request
  ) {
    return ResponseEntity.ok(testsCasesService.update(testCaseId, request));
  }

  @DeleteMapping("/{testCaseId}")
  public ResponseEntity<Void> deleteTestCase(@PathVariable UUID testCaseId) {
    testsCasesService.delete(testCaseId);
    return ResponseEntity.ok().build();
  }
}

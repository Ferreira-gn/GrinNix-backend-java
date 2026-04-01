package com.ferreira_gn.grannix.controller;

import com.ferreira_gn.grannix.model.dto.request.submissions.CreateSubmissions;
import com.ferreira_gn.grannix.model.dto.request.submissions.UpdateSubmissionRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.submissions.SubmissionsResponseDTO;
import com.ferreira_gn.grannix.model.services.SubmissionsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/submissions")
@RequiredArgsConstructor
public class SubmissionsController {
    private final SubmissionsService submissionsService;

    @PostMapping("/users/{userId}/problems/{problemId}/language/{languageId}")
    public ResponseEntity<SubmissionsResponseDTO> createSubmissions(
            @PathVariable UUID userId,
            @PathVariable UUID problemId,
            @PathVariable UUID languageId,
            @RequestBody @Valid CreateSubmissions request
    ) {
        return ResponseEntity.ok(submissionsService.register(userId, problemId, languageId, request));
    }


    @GetMapping("/{submissionId}")
    public ResponseEntity<SubmissionsResponseDTO> fetchSubmission(@PathVariable UUID submissionId) {
        return ResponseEntity.ok(submissionsService.fetch(submissionId));
    }

    @GetMapping
    public ResponseEntity<List<SubmissionsResponseDTO>> listSubmissions() {
        return ResponseEntity.ok(submissionsService.list());
    }

    @PutMapping("/{submissionId}")
    public ResponseEntity<SubmissionsResponseDTO> updateSubmission(
            @PathVariable UUID submissionId,
            @RequestBody @Valid UpdateSubmissionRequestDTO request
    ) {
        return ResponseEntity.ok(submissionsService.update(submissionId, request));
    }

    @DeleteMapping("/{submissionId}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable UUID submissionId) {
        submissionsService.delete(submissionId);
        return ResponseEntity.ok().build();
    }
}

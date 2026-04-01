package com.ferreira_gn.grannix.controller;

import com.ferreira_gn.grannix.model.dto.request.signatures.CreateSignatureRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.signatures.UpdateSignatureRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.signatures.SignaturesResponseDTO;
import com.ferreira_gn.grannix.model.services.SignaturesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/signatures")
@RequiredArgsConstructor
public class SignaturesController {
    private final SignaturesService signaturesService;

    @PostMapping("/language/{languageId}/problem/{problemId}")
    public ResponseEntity<SignaturesResponseDTO> createSignature(
            @PathVariable UUID languageId,
            @PathVariable UUID problemId,
            @RequestBody @Valid CreateSignatureRequestDTO request
    ) {
        return ResponseEntity.ok(signaturesService.register(languageId, problemId, request));
    }

    @GetMapping("/{signatureId}")
    public ResponseEntity<SignaturesResponseDTO> fetchSignature(@PathVariable UUID signatureId) {
        return ResponseEntity.ok(signaturesService.fetch(signatureId));
    }

    @GetMapping("/languages/{languageId}/problems/{problemId}")
    public ResponseEntity<SignaturesResponseDTO> fetchSignature(
            @PathVariable UUID languageId,
            @PathVariable UUID problemId
    ) {
        return ResponseEntity.ok(signaturesService.fetch(languageId, problemId));
    }

    @GetMapping
    public ResponseEntity<List<SignaturesResponseDTO>> listSignatures() {
        return ResponseEntity.ok(signaturesService.list());
    }

    @PutMapping("/{signatureId}")
    public ResponseEntity<SignaturesResponseDTO> updateSignautre(
            @PathVariable UUID signatureId,
            @RequestBody @Valid UpdateSignatureRequestDTO request
    ) {
        return ResponseEntity.ok(signaturesService.update(signatureId, request));
    }

    @DeleteMapping("/{signatureId}")
    public ResponseEntity<Void> deleteSignature(@PathVariable UUID signatureId) {
        signaturesService.delete(signatureId);
        return ResponseEntity.ok().build();
    }
}

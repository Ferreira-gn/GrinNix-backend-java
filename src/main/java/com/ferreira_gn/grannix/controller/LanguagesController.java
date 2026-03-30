package com.ferreira_gn.grannix.controller;

import com.ferreira_gn.grannix.dto.request.languages.UpdateLanguageRequestDTO;
import com.ferreira_gn.grannix.dto.request.languages.CreateLanguageRequestDTO;
import com.ferreira_gn.grannix.dto.response.languages.LanguageResponseDTO;
import com.ferreira_gn.grannix.services.LanguagesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/languages")
@RequiredArgsConstructor
public class LanguagesController {
    private final LanguagesService languagesService;

    @PostMapping
    public ResponseEntity<LanguageResponseDTO> createLanguage(@RequestBody @Valid CreateLanguageRequestDTO request) {
        return ResponseEntity.ok(languagesService.register(request));
    }

    @GetMapping("/{languageId}")
    public ResponseEntity<LanguageResponseDTO> fetchLanguage(@PathVariable UUID languageId) {
        return ResponseEntity.ok(languagesService.fetch(languageId));
    }

    @GetMapping
    public ResponseEntity<List<LanguageResponseDTO>> listLanguages() {
        return ResponseEntity.ok(languagesService.list());
    }

    @PutMapping("/{languageId}")
    public ResponseEntity<LanguageResponseDTO> updateLanguage(
            @PathVariable UUID languageId,
            @RequestBody @Valid UpdateLanguageRequestDTO request
    ) {
        return ResponseEntity.ok(languagesService.update(languageId, request));
    }

    @DeleteMapping("/{languageId}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable UUID languageId) {
        languagesService.delete(languageId);
        return ResponseEntity.ok().build();
    }
}

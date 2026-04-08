package com.ferreira_gn.grannix.controller;

import com.ferreira_gn.grannix.model.dto.request.languages.CreateLanguageRequestDTO;
import com.ferreira_gn.grannix.model.dto.request.languages.UpdateLanguageRequestDTO;
import com.ferreira_gn.grannix.model.dto.response.languages.LanguageResponseDTO;
import com.ferreira_gn.grannix.model.services.LanguagesService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/languages")
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
public class LanguagesController {

  private final LanguagesService languagesService;

  @PostMapping
  public ResponseEntity<LanguageResponseDTO> createLanguage(
    @RequestBody @Valid CreateLanguageRequestDTO request
  ) {
    return ResponseEntity.ok(languagesService.register(request));
  }

  @GetMapping("/{languageId}")
  public ResponseEntity<LanguageResponseDTO> fetchLanguage(
    @PathVariable UUID languageId
  ) {
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

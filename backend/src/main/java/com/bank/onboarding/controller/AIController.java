package com.bank.onboarding.controller;

import com.bank.onboarding.dto.AIAnalyzeRequestDTO;
import com.bank.onboarding.dto.AIAnalyzeResponseDTO;
import com.bank.onboarding.entity.AIResults;
import com.bank.onboarding.repository.AIResultsRepository;
import com.bank.onboarding.service.AIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIController {
    private final AIService aiService;
    private final AIResultsRepository aiResultsRepository;

    @Operation(summary = "Analyze CDD data with AI", description = "Calls Bedrock API for CDD analysis.",
        responses = {
            @ApiResponse(responseCode = "200", description = "AI analysis result returned")
        })
    @PostMapping("/analyze")
    public ResponseEntity<AIAnalyzeResponseDTO> analyzeCDD(@RequestBody AIAnalyzeRequestDTO request) {
        AIAnalyzeResponseDTO response = aiService.analyzeCDD(request);
        // Persist result
        AIResults result = AIResults.builder()
                .caseId((String) request.getInput().getOrDefault("caseId", ""))
                .conflicts(response.getConflicts() != null ? response.getConflicts().toString() : null)
                .missingFields(response.getMissing_fields() != null ? response.getMissing_fields().toString() : null)
                .recommendation(response.getRecommendation())
                .createdAt(LocalDateTime.now())
                .build();
        aiResultsRepository.save(result);
        return ResponseEntity.ok(response);
    }
}
package com.bank.onboarding.controller;

import com.bank.onboarding.dto.JourneyDecisionDTO;
import com.bank.onboarding.entity.CaseJourney;
import com.bank.onboarding.repository.CaseJourneyRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/journey")
@RequiredArgsConstructor
public class JourneyController {
    private final CaseJourneyRepository caseJourneyRepository;

    @Operation(summary = "Get onboarding journey decision", description = "Returns onboarding route recommendation.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Journey decision returned")
        })
    @GetMapping("/decision/{caseId}")
    public ResponseEntity<JourneyDecisionDTO> getDecision(@PathVariable String caseId) {
        return caseJourneyRepository.findByCaseId(caseId)
                .map(journey -> ResponseEntity.ok(JourneyDecisionDTO.builder()
                        .caseId(caseId)
                        .journeyType(journey.getJourneyType())
                        .build()))
                .orElseGet(() -> ResponseEntity.ok(JourneyDecisionDTO.builder()
                        .caseId(caseId)
                        .journeyType("Standard") // Default/mock
                        .build()));
    }
}
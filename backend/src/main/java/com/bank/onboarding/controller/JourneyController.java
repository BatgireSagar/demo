package com.bank.onboarding.controller;

import com.bank.onboarding.dto.JourneyDecisionDTO;
import com.bank.onboarding.entity.CaseJourney;
import com.bank.onboarding.repository.CaseJourneyRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<JourneyDecisionDTO> getJourneyDecision(@PathVariable String caseId) {
        Optional<CaseJourney> journeyOpt = caseJourneyRepository.findByCaseId(caseId);
        if (journeyOpt.isPresent()) {
            CaseJourney journey = journeyOpt.get();
            return ResponseEntity.ok(JourneyDecisionDTO.builder()
                    .caseId(journey.getCaseId())
                    .journeyType(journey.getJourneyType())
                    .build());
        } else {
            // Mocked response if not found
            return ResponseEntity.ok(JourneyDecisionDTO.builder()
                    .caseId(caseId)
                    .journeyType("Standard")
                    .build());
        }
    }
}
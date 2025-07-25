package com.bank.onboarding.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact-client")
public class ContactClientController {
    @Operation(summary = "Contact client for clarification", description = "Simulates message/email to client.",
        responses = {@ApiResponse(responseCode = "200", description = "Contact status")})
    @PostMapping("/{caseId}")
    public ResponseEntity<String> contactClient(@PathVariable String caseId) {
        // Simulate sending message/email
        return ResponseEntity.ok("Client with caseId " + caseId + " has been contacted for clarification.");
    }
}
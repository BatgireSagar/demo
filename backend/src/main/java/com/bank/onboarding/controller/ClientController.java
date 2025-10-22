package com.bank.onboarding.controller;

import com.bank.onboarding.dto.ClientInfoDTO;
import com.bank.onboarding.entity.ClientInfo;
import com.bank.onboarding.repository.ClientInfoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientInfoRepository clientInfoRepository;

    @Operation(summary = "Capture CDD info", description = "Accepts user-entered CDD data.",
        responses = {@ApiResponse(responseCode = "200", description = "CDD info captured")})
    @PostMapping("/capture")
    public ResponseEntity<ClientInfoDTO> captureCDD(@RequestBody ClientInfoDTO dto) {
        ClientInfo entity = ClientInfo.builder()
                .caseId(dto.getCaseId())
                .registrationNo(dto.getRegistrationNo())
                .clientName(dto.getClientName())
                .country(dto.getCountry())
                .sla(dto.getSla())
                .assignedTo(dto.getAssignedTo())
                .fastTrackStatus(dto.getFastTrackStatus())
                .fullLegalName(dto.getFullLegalName())
                .registeredNumber(dto.getRegisteredNumber())
                .registeredAddress(dto.getRegisteredAddress())
                .legalForm(dto.getLegalForm())
                .countryOfEstablishment(dto.getCountryOfEstablishment())
                .dateOfIncorporation(dto.getDateOfIncorporation())
                .tradingName(dto.getTradingName())
                .build();
        clientInfoRepository.save(entity);
        return ResponseEntity.ok(dto);
    }
}
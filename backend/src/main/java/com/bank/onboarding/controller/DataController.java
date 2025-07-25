package com.bank.onboarding.controller;

import com.bank.onboarding.dto.*;
import com.bank.onboarding.entity.*;
import com.bank.onboarding.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class DataController {
    private final ClientInfoRepository clientInfoRepository;
    private final CompaniesHouseDataRepository companiesHouseDataRepository;
    private final CustomerSystemDataRepository customerSystemDataRepository;

    @Operation(summary = "Compare data sources", description = "Fetches external data (mocked Companies House, internal Customer System)",
        responses = {@ApiResponse(responseCode = "200", description = "Comparison data returned")})
    @GetMapping("/compare/{caseId}")
    public ResponseEntity<DataCompareResponseDTO> compareData(@PathVariable String caseId) {
        Optional<ClientInfo> cddOpt = clientInfoRepository.findByCaseId(caseId);
        Optional<CompaniesHouseData> chOpt = companiesHouseDataRepository.findByCaseId(caseId);
        Optional<CustomerSystemData> csOpt = customerSystemDataRepository.findByCaseId(caseId);

        DataCompareResponseDTO dto = DataCompareResponseDTO.builder()
                .cddInfo(cddOpt.map(this::toClientInfoDTO).orElse(null))
                .companiesHouse(chOpt.map(this::toCompaniesHouseDTO).orElse(null))
                .customerSystem(csOpt.map(this::toCustomerSystemDTO).orElse(null))
                .build();
        return ResponseEntity.ok(dto);
    }

    private ClientInfoDTO toClientInfoDTO(ClientInfo e) {
        return ClientInfoDTO.builder()
                .caseId(e.getCaseId())
                .registrationNo(e.getRegistrationNo())
                .clientName(e.getClientName())
                .country(e.getCountry())
                .sla(e.getSla())
                .assignedTo(e.getAssignedTo())
                .fastTrackStatus(e.getFastTrackStatus())
                .fullLegalName(e.getFullLegalName())
                .registeredNumber(e.getRegisteredNumber())
                .registeredAddress(e.getRegisteredAddress())
                .legalForm(e.getLegalForm())
                .countryOfEstablishment(e.getCountryOfEstablishment())
                .dateOfIncorporation(e.getDateOfIncorporation())
                .tradingName(e.getTradingName())
                .build();
    }
    private CompaniesHouseDTO toCompaniesHouseDTO(CompaniesHouseData e) {
        return CompaniesHouseDTO.builder()
                .caseId(e.getCaseId())
                .fullLegalName(e.getFullLegalName())
                .registeredNumber(e.getRegisteredNumber())
                .registeredAddress(e.getRegisteredAddress())
                .legalForm(e.getLegalForm())
                .countryOfEstablishment(e.getCountryOfEstablishment())
                .dateOfIncorporation(e.getDateOfIncorporation())
                .tradingName(e.getTradingName())
                .build();
    }
    private CustomerSystemDTO toCustomerSystemDTO(CustomerSystemData e) {
        return CustomerSystemDTO.builder()
                .caseId(e.getCaseId())
                .fullLegalName(e.getFullLegalName())
                .registeredNumber(e.getRegisteredNumber())
                .registeredAddress(e.getRegisteredAddress())
                .legalForm(e.getLegalForm())
                .countryOfEstablishment(e.getCountryOfEstablishment())
                .dateOfIncorporation(e.getDateOfIncorporation())
                .tradingName(e.getTradingName())
                .build();
    }
}
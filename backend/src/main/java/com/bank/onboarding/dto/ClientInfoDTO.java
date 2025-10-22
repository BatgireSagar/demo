package com.bank.onboarding.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientInfoDTO {
    private String caseId;
    private String registrationNo;
    private String clientName;
    private String country;
    private String sla;
    private String assignedTo;
    private Boolean fastTrackStatus;
    private String fullLegalName;
    private String registeredNumber;
    private String registeredAddress;
    private String legalForm;
    private String countryOfEstablishment;
    private LocalDate dateOfIncorporation;
    private String tradingName;
}
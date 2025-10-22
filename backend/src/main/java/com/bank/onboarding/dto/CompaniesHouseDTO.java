package com.bank.onboarding.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompaniesHouseDTO {
    private String caseId;
    private String fullLegalName;
    private String registeredNumber;
    private String registeredAddress;
    private String legalForm;
    private String countryOfEstablishment;
    private LocalDate dateOfIncorporation;
    private String tradingName;
}
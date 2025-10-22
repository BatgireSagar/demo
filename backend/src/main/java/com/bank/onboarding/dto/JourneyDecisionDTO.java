package com.bank.onboarding.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JourneyDecisionDTO {
    private String caseId;
    private String journeyType; // Fast Track, Standard, EDD
}
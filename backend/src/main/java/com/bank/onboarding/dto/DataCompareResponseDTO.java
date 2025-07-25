package com.bank.onboarding.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataCompareResponseDTO {
    private ClientInfoDTO cddInfo;
    private CompaniesHouseDTO companiesHouse;
    private CustomerSystemDTO customerSystem;
}
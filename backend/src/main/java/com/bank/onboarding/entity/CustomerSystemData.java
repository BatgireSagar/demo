package com.bank.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer_system_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerSystemData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String caseId;

    private String fullLegalName;
    private String registeredNumber;
    private String registeredAddress;
    private String legalForm;
    private String countryOfEstablishment;
    private LocalDate dateOfIncorporation;
    private String tradingName;
}
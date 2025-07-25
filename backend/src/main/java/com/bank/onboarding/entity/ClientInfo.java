package com.bank.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "client_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String caseId;
    private String registrationNo;
    private String clientName;
    private String country;
    private String sla;
    private String assignedTo;
    private Boolean fastTrackStatus;

    // CDD fields
    private String fullLegalName;
    private String registeredNumber;
    private String registeredAddress;
    private String legalForm;
    private String countryOfEstablishment;
    private LocalDate dateOfIncorporation;
    private String tradingName;
}
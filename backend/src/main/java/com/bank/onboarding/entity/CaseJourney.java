package com.bank.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "case_journey")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaseJourney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String caseId;

    private String journeyType; // Fast Track, Standard, EDD
    private String status;
    private LocalDateTime updatedAt;
}
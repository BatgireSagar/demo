package com.bank.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ai_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AIResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String caseId;

    @Lob
    private String conflicts; // JSON array

    @Lob
    private String missingFields; // JSON array

    private String recommendation;
    private LocalDateTime createdAt;
}
package com.bank.onboarding.dto;

import lombok.*;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AIAnalyzeResponseDTO {
    private List<Map<String, String>> conflicts;
    private List<String> missing_fields;
    private String recommendation;
}
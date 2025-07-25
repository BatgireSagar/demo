package com.bank.onboarding.dto;

import lombok.*;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AIAnalyzeRequestDTO {
    private Map<String, Object> input;
}
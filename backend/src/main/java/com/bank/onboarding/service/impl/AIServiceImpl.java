package com.bank.onboarding.service.impl;

import com.bank.onboarding.dto.AIAnalyzeRequestDTO;
import com.bank.onboarding.dto.AIAnalyzeResponseDTO;
import com.bank.onboarding.service.AIService;
import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AIService {
    @Override
    public AIAnalyzeResponseDTO analyzeCDD(AIAnalyzeRequestDTO request) {
        // TODO: Integrate with AWS Bedrock API (LAGLamda-cddGen)
        // For now, return a mocked response
        return AIAnalyzeResponseDTO.builder()
                .recommendation("Fast Track")
                .build();
    }
}
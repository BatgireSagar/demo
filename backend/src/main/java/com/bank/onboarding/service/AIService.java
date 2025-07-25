package com.bank.onboarding.service;

import com.bank.onboarding.dto.AIAnalyzeRequestDTO;
import com.bank.onboarding.dto.AIAnalyzeResponseDTO;

public interface AIService {
    AIAnalyzeResponseDTO analyzeCDD(AIAnalyzeRequestDTO request);
}
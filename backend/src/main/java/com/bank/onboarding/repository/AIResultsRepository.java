package com.bank.onboarding.repository;

import com.bank.onboarding.entity.AIResults;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AIResultsRepository extends JpaRepository<AIResults, Long> {
    Optional<AIResults> findByCaseId(String caseId);
}
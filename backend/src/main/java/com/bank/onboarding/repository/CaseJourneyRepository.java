package com.bank.onboarding.repository;

import com.bank.onboarding.entity.CaseJourney;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CaseJourneyRepository extends JpaRepository<CaseJourney, Long> {
    Optional<CaseJourney> findByCaseId(String caseId);
}
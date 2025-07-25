package com.bank.onboarding.repository;

import com.bank.onboarding.entity.CompaniesHouseData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompaniesHouseDataRepository extends JpaRepository<CompaniesHouseData, Long> {
    Optional<CompaniesHouseData> findByCaseId(String caseId);
}
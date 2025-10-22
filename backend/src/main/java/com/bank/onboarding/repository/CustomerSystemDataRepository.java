package com.bank.onboarding.repository;

import com.bank.onboarding.entity.CustomerSystemData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerSystemDataRepository extends JpaRepository<CustomerSystemData, Long> {
    Optional<CustomerSystemData> findByCaseId(String caseId);
}
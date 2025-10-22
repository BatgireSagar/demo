package com.bank.onboarding.repository;

import com.bank.onboarding.entity.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientInfoRepository extends JpaRepository<ClientInfo, Long> {
    Optional<ClientInfo> findByCaseId(String caseId);
}
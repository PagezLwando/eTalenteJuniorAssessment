package com.enviro.assessment.grad001.lwandonodume.backend.repository;

import com.enviro.assessment.grad001.lwandonodume.backend.models.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
}
package com.enviro.assessment.grad001.lwandonodume.backend.services;

import com.enviro.assessment.grad001.lwandonodume.backend.models.Investor;

import java.util.List;

public interface InvestorService {
    Investor save(Investor investor);

    Investor findById(Long id);

    List<Investor> findAllInvestor();
}

package com.enviro.assessment.grad001.lwandonodume.backend.services.Impl;

import com.enviro.assessment.grad001.lwandonodume.backend.models.Investor;
import com.enviro.assessment.grad001.lwandonodume.backend.repository.InvestorRepository;
import com.enviro.assessment.grad001.lwandonodume.backend.services.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    @Override
    public Investor save(Investor investor) {
        return investorRepository.save(investor);
    }

    @Override
    public Investor findById(Long id) {
        return investorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Investor> findAllInvestor() {
        return investorRepository.findAll();
    }
}

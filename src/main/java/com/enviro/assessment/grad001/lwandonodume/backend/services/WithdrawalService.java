package com.enviro.assessment.grad001.lwandonodume.backend.services;

import com.enviro.assessment.grad001.lwandonodume.backend.models.WithdrawalNotice;

import java.util.List;

public interface WithdrawalService {
    WithdrawalNotice notify(WithdrawalNotice withdrawalNotice);

    WithdrawalNotice findById(Long id);

    List<WithdrawalNotice> findAllWithdrawalNotice();

    List<WithdrawalNotice> downloadWithdrawalNotice();
}

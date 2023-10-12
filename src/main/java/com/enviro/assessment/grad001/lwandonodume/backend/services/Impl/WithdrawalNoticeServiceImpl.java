package com.enviro.assessment.grad001.lwandonodume.backend.services.Impl;

import com.enviro.assessment.grad001.lwandonodume.backend.exceptions.AgeException;
import com.enviro.assessment.grad001.lwandonodume.backend.exceptions.WithdrawalException;
import com.enviro.assessment.grad001.lwandonodume.backend.models.Investor;
import com.enviro.assessment.grad001.lwandonodume.backend.models.Product;
import com.enviro.assessment.grad001.lwandonodume.backend.models.SendEmail;
import com.enviro.assessment.grad001.lwandonodume.backend.models.WithdrawalNotice;
import com.enviro.assessment.grad001.lwandonodume.backend.repository.WithdrawalNoticeRepository;
import com.enviro.assessment.grad001.lwandonodume.backend.services.InvestorService;
import com.enviro.assessment.grad001.lwandonodume.backend.services.ProductService;
import com.enviro.assessment.grad001.lwandonodume.backend.services.SendEmailService;
import com.enviro.assessment.grad001.lwandonodume.backend.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.List;

@Service
public class WithdrawalNoticeServiceImpl implements WithdrawalService {

    @Autowired
    WithdrawalNoticeRepository withdrawalNoticeRepository;

    @Autowired
    ProductService productService;

    @Autowired
    SendEmailService sendEmailService;

    @Autowired
    InvestorService investorService;

    @Override
    public WithdrawalNotice notify(WithdrawalNotice withdrawalNotice) {
        Product product = productService.findById(withdrawalNotice.getProductId());
        Investor investor = investorService.findById(product.getInvestorId());
        try {
            if (withdrawalNotice.getAmount() > product.getCurrentBalance()) {
                throw new AgeException("You cannot withdraw more than available balance.");
            }
            if (withdrawalNotice.getAmount() > (product.getCurrentBalance() * 0.9)) {
                throw new WithdrawalException("Investors cannot withdraw an AMOUNT more than 90% of the current BALANCE");
            }
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
        }
        SendEmail sendEmail = new SendEmail();
        sendEmail.setTo(investor.getEmailAddress());
        String message = "Withdrawal successfully\n" + "Current balance is: " + product.getCurrentBalance() + "\n Available balance is: " + withdrawalNotice.getAmount();
        sendEmail.setBody(message);
        sendEmail.setSubject("eTalent Withdrawal Notification");
        sendEmailService.sendEmail(sendEmail);

        return withdrawalNoticeRepository.save(withdrawalNotice);
    }

    @Override
    public WithdrawalNotice findById(Long id) {
        return withdrawalNoticeRepository.findById(id).orElse(null);
    }

    @Override
    public List<WithdrawalNotice> findAllWithdrawalNotice() {
        return withdrawalNoticeRepository.findAll();
    }

    @Override
    public List<WithdrawalNotice> downloadWithdrawalNotice() {
        String fileName = "C:\\Projects\\Assessment\\eTalent\\backend\\src\\main\\resources\\withdrawalStatement.csv";
        try {
//        List<WithdrawalNotice> withdrawalNotices =
            FileWriter writer = new FileWriter(fileName);
            writer.write("Notice ID,Product ID,Notice Type,Notice Date,Notice Message");

            for (WithdrawalNotice withdrawalNotice : withdrawalNotices) {
                writer.write(notice.getId() + "," + notice.getProductId() + "," + notice.getType() + "," + notice.getDate() + "," + notice.getMessage());
            }
            writer.close();
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
        }
        return null;
    }
}

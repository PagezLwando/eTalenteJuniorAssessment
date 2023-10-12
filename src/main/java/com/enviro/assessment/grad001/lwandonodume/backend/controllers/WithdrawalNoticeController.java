package com.enviro.assessment.grad001.lwandonodume.backend.controllers;

import com.enviro.assessment.grad001.lwandonodume.backend.models.WithdrawalNotice;
import com.enviro.assessment.grad001.lwandonodume.backend.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/withdrawalnotice/v1")
public class WithdrawalNoticeController {

    @Autowired
    WithdrawalService withdrawalService;
    @PostMapping("/post")
    public ResponseEntity<WithdrawalNotice> notify(@RequestBody WithdrawalNotice withdrawalNotice){
        return ResponseEntity.ok(withdrawalService.notify(withdrawalNotice));
    }

    @GetMapping(path = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WithdrawalNotice>> getAllWithdrawalNotices() {
        return ResponseEntity.ok(withdrawalService.findAllWithdrawalNotice());
    }
}

package com.enviro.assessment.grad001.lwandonodume.backend.controllers;

import com.enviro.assessment.grad001.lwandonodume.backend.models.Investor;
import com.enviro.assessment.grad001.lwandonodume.backend.services.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investor/v1")
public class InvestorController {
    @Autowired
    InvestorService investorService;

    @PostMapping("/post")
    public ResponseEntity<Investor> save(@RequestBody Investor investor){
        return ResponseEntity.ok(investorService.save(investor));
    }

    @GetMapping(path = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Investor>> getAllInvestor() {
        return ResponseEntity.ok(investorService.findAllInvestor());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Investor> findInvestorById(@PathVariable Long id) {
        Investor investor =  investorService.findById(id);
         if (investor != null) {
             return ResponseEntity.ok(investor);
         } else {
             return ResponseEntity.notFound().build();
         }
    }
}
package com.enviro.assessment.grad001.lwandonodume.backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "Withdrawal_notices")
public class WithdrawalNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "date_requested")
    private LocalDate dateRequested;
    @Column(name = "date_processed")
    private LocalDate dateProcessed;
    @Column(name = "status")
    private String status;
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_name")
    @Enumerated(EnumType.STRING)
    private Type accountName;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(LocalDate dateRequested) {
        this.dateRequested = dateRequested;
    }

    public LocalDate getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(LocalDate dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Type getAccountName() {
        return accountName;
    }

    public void setAccountName(Type accountName) {
        this.accountName = accountName;
    }
}

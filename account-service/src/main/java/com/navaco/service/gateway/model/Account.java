package com.navaco.service.gateway.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "CIF_NUMBER")
    private Long cif;

    public Account() {
    }

    public Account(String accountNumber, Long cif) {
        this.accountNumber = accountNumber;
        this.cif = cif;
    }

    public Account(Long id, String accountNumber, Long cif) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.cif = cif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCif() {
        return cif;
    }

    public void setCif(Long cif) {
        this.cif = cif;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", cif=" + cif +
                '}';
    }
}

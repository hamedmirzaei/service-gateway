package com.navaco.service.gateway.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Customer")
public class Customer implements Serializable {

    private Long customerId;
    private String name;
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(Long customerId, String name, List<Account> accounts) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long cifID) {
        this.customerId = cifID;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerId=" + customerId +
                ", accounts=" + accounts +
                '}';
    }
}

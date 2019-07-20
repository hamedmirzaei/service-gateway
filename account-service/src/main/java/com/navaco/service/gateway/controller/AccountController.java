package com.navaco.service.gateway.controller;

import com.navaco.service.gateway.model.Account;
import com.navaco.service.gateway.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable(value = "id") Long accountId) {
        return accountService.getAccount(accountId);
    }

    @PostMapping
    public Account addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

}

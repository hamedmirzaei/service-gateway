package com.navaco.service.gateway;

import com.navaco.service.gateway.model.Account;
import com.navaco.service.gateway.service.AccountService;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(String... args) throws Exception {

        DataFactory df = new DataFactory();
        for (Long i = 1L; i <= 100L; i++) {
            Account account = new Account();
            account.setId(i);
            account.setAccountNumber(df.getNumberText(13));
            account.setCif(Long.parseLong(df.getNumberBetween(1000000, 9000000) + ""));
            accountService.addAccount(account);
        }
    }
}

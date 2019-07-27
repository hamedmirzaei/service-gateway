package com.navaco.service.gateway.repository;

import com.navaco.service.gateway.model.Account;
import com.navaco.service.gateway.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository {

    List<Customer> customers = new ArrayList<>();

    CustomerRepository() {
        customers.add(new Customer(1l, "Hamed Mirzaei", Arrays.asList(
                new Account(1l, "00002353436843", 2000000l),
                new Account(2l, "00005348626541", 5000000l)
        )));

        customers.add(new Customer(2l, "Ali Mirzaei", Arrays.asList(
                new Account(3l, "00008767431332", 2000000l),
                new Account(4l, "00005645573212", 5000000l)
        )));
    }

    public Customer getCustomer(Long customerId) {
        for (Customer customer : customers) {
            if (customerId.equals(customer.getCustomerId()))
                return customer;
        }
        return new Customer(0l, "Unknown", null);
    }

}

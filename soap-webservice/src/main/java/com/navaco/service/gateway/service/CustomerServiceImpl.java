package com.navaco.service.gateway.service;

import com.navaco.service.gateway.model.Account;
import com.navaco.service.gateway.model.Customer;
import com.navaco.service.gateway.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(String customerId) {
        return customerRepository.getCustomer(Long.parseLong(customerId));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public Account getAccountOfCustomer(String customerId, String accountId) {
        return customerRepository.getAccountOfCustomer(Long.parseLong(customerId), Long.parseLong(accountId));
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }
}

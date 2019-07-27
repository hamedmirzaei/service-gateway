package com.navaco.service.gateway.service;

import com.navaco.service.gateway.model.Customer;
import com.navaco.service.gateway.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

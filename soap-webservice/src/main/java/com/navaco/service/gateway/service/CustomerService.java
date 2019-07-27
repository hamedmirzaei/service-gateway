package com.navaco.service.gateway.service;

import com.navaco.service.gateway.model.Customer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "CustomerService")
public interface CustomerService {

    @WebMethod()
    @WebResult(name = "Customer")
    public Customer getCustomer(@WebParam(name = "CustomerId") String customerId);

    @WebMethod()
    @WebResult(name = "Customers")
    public List<Customer> getAllCustomers();

    @WebMethod()
    @WebResult(name = "Customer")
    public Customer addCustomer(@WebParam(name = "Customer") Customer customer);

}

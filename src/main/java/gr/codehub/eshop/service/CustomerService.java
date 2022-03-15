package gr.codehub.eshop.service;

import gr.codehub.eshop.exception.AccountException;
import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Customer;

import java.util.List;

public interface CustomerService {

    int register(Customer customer) throws CustomerException;
    Customer login(int customerId) throws CustomerException;
    void doTransaction(int customerId, int accountId, double amount)
        throws CustomerException, AccountException;
    void fillData();
    List<Customer> customerList();
    Customer update(int customerId, Customer customer);

    boolean delete(int customerId);
}

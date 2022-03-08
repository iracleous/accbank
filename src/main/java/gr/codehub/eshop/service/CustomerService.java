package gr.codehub.eshop.service;

import gr.codehub.eshop.exception.AccountException;
import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Customer;

public interface CustomerService {
    void register(Customer customer) throws CustomerException;
    void login(Customer customer) throws CustomerException;
    void doTransaction(int customerId, int accountId, double amount)
        throws CustomerException, AccountException;
}

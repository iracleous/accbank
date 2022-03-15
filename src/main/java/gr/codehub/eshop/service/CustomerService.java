package gr.codehub.eshop.service;

import gr.codehub.eshop.exception.AccountException;
import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Customer;

public interface CustomerService {
    int register(Customer customer) throws CustomerException;
    Customer login(int customerId) throws CustomerException;
    void doTransaction(int customerId, int accountId, double amount)
        throws CustomerException, AccountException;

    void fillData();
}

package gr.codehub.eshop.service;

import gr.codehub.eshop.exception.AccountException;
import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Account;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.AccountRepository;
import gr.codehub.eshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;

     @Override
    public void register(Customer customer) throws CustomerException {

    }

    @Override
    public void login(Customer customer) throws CustomerException {

    }

    @Override
    public void doTransaction(int customerId, int accountId, double amount) throws CustomerException, AccountException {

        Customer customer = customerRepository.readCustomer(customerId);
        if (customer == null)
        {
            throw new CustomerException("The customer was not found");
        }
        Account account = accountRepository.readAccount(accountId);
        if (account == null)
        {
            throw new AccountException("The account was not found");
        }
        if(account.getCustomer().getId()!= customer.getId() ){
            throw new CustomerException("Invalid owner");
        }

        account.setBalance( account.getBalance().add(new BigDecimal(amount)) );
    }
}

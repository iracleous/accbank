package gr.codehub.eshop.service;

import gr.codehub.eshop.exception.AccountException;
import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Account;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.Repository;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private Repository<Customer> customerRepository;
    private Repository<Account> accountRepository;

     @Override
    public void register(Customer customer) throws CustomerException {

    }

    @Override
    public void login(Customer customer) throws CustomerException {

    }

    @Override
    public void doTransaction(int customerId, int accountId, double amount) throws CustomerException, AccountException {

        Customer customer = customerRepository.read(customerId);
        if (customer == null)
        {
            throw new CustomerException("The customer was not found");
        }
        Account account = accountRepository.read(accountId);
        if (account == null)
        {
            throw new AccountException("The account was not found");
        }
        if(account.getCustomer().getId()!= customer.getId() ){
            throw new CustomerException("Invalid owner");
        }

        account.setBalance( account.getBalance().add(new BigDecimal(amount)) );
    }


    @Override
    public void fillData() {
        Customer customer = new Customer();
        customer.setId(45);
        customer.setName("Dimitris");
        customer.setDateOfBirth(new Date(100,2,15));
        customer.setStatus(true);

        customerRepository.create(customer);


    }
}

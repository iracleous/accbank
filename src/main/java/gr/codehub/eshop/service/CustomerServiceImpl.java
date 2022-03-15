package gr.codehub.eshop.service;

import gr.codehub.eshop.exception.AccountException;
import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Account;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.AccountRepository;
import gr.codehub.eshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;


    @Override
    public int register(Customer customer) throws CustomerException {
        customerRepository.create(customer);
        return customer.getId();
    }

    @Override
    public Customer login(int customerId) throws CustomerException {
        return customerRepository.read(customerId);
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

    @Override
    public List<Customer> customerList() {
        return customerRepository.read();
    }

    @Override
    public Customer update(int customerId, Customer customer) {
        if (customer == null)
            return null;
        if (customer.getAddress() == null)
            return null;
        return customerRepository.update(customerId,customer.getAddress());
    }

    @Override
    public boolean delete(int customerId) {
        try {
            return customerRepository.delete(customerId);
        }
        catch(Exception e)
        {
            return false;
        }
    }


}

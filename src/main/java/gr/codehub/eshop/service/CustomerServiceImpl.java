package gr.codehub.eshop.service;

import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.CustomerRepository;
import gr.codehub.eshop.repository.CustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository  ;

    public CustomerServiceImpl (CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    public void register(Customer customer) throws CustomerException {

    }

    @Override
    public void login(Customer customer) throws CustomerException {

    }
}

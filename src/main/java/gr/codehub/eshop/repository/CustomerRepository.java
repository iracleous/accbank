package gr.codehub.eshop.repository;

import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Customer;

import java.util.List;

public interface CustomerRepository {
    //CRUD
    boolean createCustomer(Customer customer);
    Customer readCustomer(int id);
    List<Customer> readCustomer();
    boolean updateCustomer(int id, String newAddress);
    boolean deleteCustomer(int id) throws CustomerException;
}

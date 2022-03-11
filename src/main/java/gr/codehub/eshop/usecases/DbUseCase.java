package gr.codehub.eshop.usecases;

import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.CustomerDbRepositoryImpl;
import gr.codehub.eshop.repository.Repository;

import java.util.Date;

public class DbUseCase {


    public void dbScenario(){
        Customer customer = new Customer();
        customer.setId(45);
        customer.setName("Stavroula");
        customer.setDateOfBirth(new Date(100, 2, 15));
        customer.setStatus(true);

        Repository<Customer> customerRepository =  new CustomerDbRepositoryImpl();

        customerRepository.create(customer);


    }
}

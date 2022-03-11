package gr.codehub.eshop.usecases;

import gr.codehub.eshop.exception.AccountException;
import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.model.Account;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.Repository;

import gr.codehub.eshop.repository.RepositoryImpl;
import gr.codehub.eshop.service.CustomerService;
import gr.codehub.eshop.service.CustomerServiceImpl;

import java.math.BigDecimal;
import java.util.Date;

public class Bank {
    private final static String NAME = "Maria I";
    private final static double CREDIT = 2000;

    public void bankUseCase() {

        Customer customer = new Customer();
        customer.setName(NAME);
        customer.setCredit(CREDIT);

        Customer anotherCustomer;
        anotherCustomer = customer;

        System.out.println(anotherCustomer);
        customer.setCredit(6000);
        customer.setName("Stavroula");
        System.out.println(anotherCustomer);

//        String customer ="Maria";
//        String anotherCustomer = customer;
//        System.out.println(anotherCustomer);
//        customer ="Giorgia";
//        System.out.println(anotherCustomer);


        double balance = 0.1;
        double balance2 = 0.2;


        if ((balance + balance2 - 0.3) <= 0.0001) {
            System.out.println(" The basket has been paid");
        } else
            System.out.println("NOT BEEN PAID");

    }

    public void commercialTransaction() {
        int id = 15;
        double amount = 200.0;
        Date dateStamp = new Date();
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Aris");
        Account account = new Account();
        account.setCustomer(customer);
        account.setBalance(new BigDecimal(amount));

        System.out.println("Customer name " + account.getCustomer().getName());
        System.out.println("Balance " + account.getBalance().add(new BigDecimal("-20")));
        System.out.println("Date = " + dateStamp);
    }

    public void manyTransactions() throws CustomerException {
        Repository<Customer> customers = new RepositoryImpl<>();


        customers.create(new Customer());

        Customer customer1 = new Customer();
        customer1.setId(45);
        customer1.setName("Dimitris");
        customer1.setDateOfBirth(new Date(100, 2, 15));
        customer1.setStatus(true);


        customers.create(customer1);

        for (Customer customer : customers.read()) {
            System.out.println(customer);
        }

        try {
            customers.delete(6);
            System.out.println("The customer has been deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void doTransaction() {

        Customer customer1 = new Customer();
        customer1.setId(45);
        customer1.setName("Dimitris");
        customer1.setDateOfBirth(new Date(100, 2, 15));
        customer1.setStatus(true);

        Account account = new Account();
        account.setId(32);
        account.setCustomer(customer1);
        account.setBalance( new BigDecimal("0.0"));

        Repository<Customer> customerRepository = new RepositoryImpl<Customer>();
        Repository accountRepository = new RepositoryImpl<Account>();

        customerRepository.create(customer1);
        accountRepository.create(account);


        CustomerService customerService =
                new CustomerServiceImpl(customerRepository, accountRepository);


        try {
            customerService.doTransaction(45, 32, 100);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } catch (AccountException e) {
            e.printStackTrace();
        }


    }


}

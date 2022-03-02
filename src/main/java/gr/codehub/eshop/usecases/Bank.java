package gr.codehub.eshop.usecases;

import gr.codehub.eshop.model.Account;
import gr.codehub.eshop.model.Customer;
import gr.codehub.eshop.repository.CustomerRepository;
import gr.codehub.eshop.repository.CustomerRepositoryImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Bank {
    private final static String NAME = "Maria I";
    private final static double CREDIT = 2000;

    public void bankUseCase(){

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


        if ( (balance+balance2 - 0.3)<= 0.0001)
        {
            System.out.println(" The basket has been paid");
        }
        else
            System.out.println("NOT BEEN PAID");

    }

    public void commercialTransaction(){
        int id = 15;
        double amount =200.0;
        Date dateStamp = new Date();
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Aris");
        Account account = new Account();
        account.setCustomer(customer);
        account.setBalance(new BigDecimal(amount));

        System.out.println("Customer name "+ account.getCustomer().getName());
        System.out.println("Balance "+ account.getBalance().add( new BigDecimal("-20"))  );
        System.out.println("Date = "+dateStamp);

    }

    public void manyTransactions(){
        CustomerRepository customers = new CustomerRepositoryImpl();


        customers.createCustomer(new Customer());
        customers.createCustomer(new Customer(3,"Aris","Athina",
                new Date(100,2,15),0.0,true));

        for (Customer customer : customers.readCustomer()){
            System.out.println(customer);
        }

        try {
            customers.deleteCustomer(3);
            System.out.println("The customer has been deleted");
        }
        catch(Exception e){
            System.out.println("An error occured");
        }
    }




}

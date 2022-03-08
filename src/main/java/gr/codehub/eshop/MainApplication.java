package gr.codehub.eshop;

import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.usecases.Bank;
import lombok.SneakyThrows;

public class MainApplication {


    public static void main(String[] args)   {
        Bank bank =  new Bank();
        try {
            bank.manyTransactions();
        } catch (CustomerException e) {
            e.printStackTrace();
        }
    }
}

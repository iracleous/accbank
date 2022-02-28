package gr.codehub.eshop;

import gr.codehub.eshop.usecases.Bank;

public class MainApplication {

    public static void main(String[] args) {
        Bank bank =  new Bank();
        bank.commercialTransaction();
    }
}

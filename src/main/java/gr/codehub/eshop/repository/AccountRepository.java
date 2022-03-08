package gr.codehub.eshop.repository;

import gr.codehub.eshop.exception.AccountException;
import gr.codehub.eshop.model.Account;

import java.util.List;

public interface AccountRepository {

    //CRUD
    boolean createAccount(Account account);
    Account readAccount(int id);
    List<Account> readAccount();
    boolean updateAccount(int id, String newLocationOfRegistrationBank);
    boolean deleteAccount(int id) throws AccountException;
      
}

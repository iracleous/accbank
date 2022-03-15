package gr.codehub.eshop.repository;

import gr.codehub.eshop.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AccountDbRepositoryImpl implements AccountRepository{
    @Override
    public boolean create(Account t) {
        return false;
    }

    @Override
    public Account read(int id) {
        return null;
    }

    @Override
    public List<Account> read() {
        return null;
    }

    @Override
    public Account update(int id, String newValue) {
        return null;
    }

    @Override
    public boolean delete(int id) throws Exception {
        return false;
    }
}

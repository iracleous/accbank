package gr.codehub.eshop;

import gr.codehub.eshop.exception.CustomerException;
import gr.codehub.eshop.usecases.Bank;
import gr.codehub.eshop.usecases.DbUseCase;
import lombok.SneakyThrows;

public class MainApplication {


    public static void main(String[] args)   {
        DbUseCase dbCase =  new DbUseCase();
        dbCase.dbScenario();
    }
}

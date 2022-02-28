package gr.codehub.eshop.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private int id;
    private BigDecimal balance;
    private Customer customer;
}

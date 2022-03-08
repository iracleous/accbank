package gr.codehub.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class Account {
    private int id;
    private String locationOfRegistrationBank;
    private BigDecimal balance;
    private Customer customer;
}

package gr.codehub.eshop.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter

public class Customer extends Entity{

    private String name;
    private String Address;
    private Date dateOfBirth;
    private double credit;
    private boolean status;
}

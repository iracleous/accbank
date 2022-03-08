package gr.codehub.eshop.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String Address;
    private Date dateOfBirth;
    private double credit;
    private boolean status;
}

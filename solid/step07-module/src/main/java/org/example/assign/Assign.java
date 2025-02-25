package org.example.assign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.customer.Customer;
import org.example.surveyor.Surveyor;

@Getter
@Setter
@AllArgsConstructor
public class Assign {
    private Customer customer;
    private Surveyor surveyor;
}

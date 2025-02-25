package org.example.distribute;

import org.example.assign.Assign;
import org.example.customer.Customer;
import org.example.surveyor.Surveyor;

import java.util.List;

public interface Distributable {
    List<Assign> distribute(List<Customer> customers, List<Surveyor> surveyors);
}

package org.example.distribute;

import org.example.assign.Assign;
import org.example.customer.Customer;
import org.example.surveyor.Surveyor;

import java.util.ArrayList;
import java.util.List;

public class RoundRobinDistributor implements Distributable {
    @Override
    public List<Assign> distribute(List<Customer> customers, List<Surveyor> surveyors) {
        int i = 0;
        List<Assign> assigns = new ArrayList<>();
        for (Customer customer: customers) {
            Surveyor surveyor = surveyors.get(i % surveyors.size());
            Assign newAssign = new Assign(customer, surveyor);
            assigns.add(newAssign);
            i++;
        }
        return assigns;
    }
}

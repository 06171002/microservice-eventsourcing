package org.example;

import java.util.Comparator;

public interface AssignRule extends Comparator<Customer> {
    boolean isSatisfied(Customer customer);
}

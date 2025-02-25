package org.example;

import java.util.Comparator;

public interface Rule extends Comparator<Customer> {
    boolean isSatisfied(Customer customer);
}

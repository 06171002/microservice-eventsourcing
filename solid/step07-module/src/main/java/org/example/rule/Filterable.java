package org.example.rule;

import org.example.customer.Customer;

public interface Filterable {
    boolean isSatisfied(Customer customer);
}

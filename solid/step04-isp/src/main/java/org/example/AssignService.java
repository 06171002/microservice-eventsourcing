package org.example;

import java.util.ArrayList;
import java.util.List;

public class AssignService {

    public List<Assign> assign(List<Customer> customers, List<Surveyor> surveyors) {

        //AgeRule ageRule = new AgeRule(30, 100);
        GenderRule rule = new GenderRule("M");
        List<Customer> filteredCustomer = new ArrayList<>();
        for (Customer customer: customers) {
            if (rule.isSatisfied(customer)) {
                filteredCustomer.add(customer);
            }
        }

        filteredCustomer.sort(rule);

        Distributable distributable = new RoundRobinDistributor();
        List<Assign> assigns = distributable.distribute(filteredCustomer, surveyors);

        return assigns;
    }
}

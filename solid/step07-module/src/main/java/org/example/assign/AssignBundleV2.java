package org.example.assign;

import org.example.customer.Customer;
import org.example.distribute.Distributable;
import org.example.distribute.RoundRobinDistributor;
import org.example.rule.Filterables;
import org.example.rule.Sortables;
import org.example.surveyor.Surveyor;

import java.util.List;

public class AssignBundleV2 {

    private List<Customer> customers;
    private List<Surveyor> surveyors;

    private Filterables filterables;
    private Sortables sortables;
    private Distributable distributable;

    public AssignBundleV2() {
    }

    public void setFilterables(Filterables filterables) {
        this.filterables = filterables;
    }

    public void setSortables(Sortables sortables) {
        this.sortables = sortables;
    }

    public void setDistributable(Distributable distributable) {
        this.distributable = distributable;
    }

    public List<Assign> assign(List<Customer> customers,
                               List<Surveyor> surveyors,
                               Filterables filterables,
                               Sortables sortables) {
        List<Customer> filteredCustomer = filterables.filter(customers);
        filteredCustomer = sortables.sort(filteredCustomer);

        Distributable distributable = new RoundRobinDistributor();
        List<Assign> assigns = distributable.distribute(filteredCustomer, surveyors);

        return assigns;
    }
}
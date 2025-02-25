package org.example.assign;

import org.example.AssignService;
import org.example.assign.repository.AssignDao;
import org.example.customer.Customer;
import org.example.customer.repository.CustomerDao;
import org.example.distribute.Distributable;
import org.example.distribute.RoundRobinDistributor;
import org.example.rule.Filterables;
import org.example.rule.GenderRule;
import org.example.rule.Sortables;
import org.example.surveyor.Surveyor;
import org.example.surveyor.repository.SurveyorDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class AssignBundleTest {

    @Test
    public void assign() {
        //
        CustomerDao customerDao = new CustomerDao();
        SurveyorDao surveyorDao = new SurveyorDao();
        AssignDao assignDao = new AssignDao();

        AssignService assignService = new AssignService(customerDao, surveyorDao, assignDao);

        GenderRule rule = new GenderRule("M");
        Filterables filterables = new Filterables(rule);
        Sortables sortables = new Sortables(rule);
        Distributable distributable = new RoundRobinDistributor();

        assignService.assign(filterables, sortables, distributable);

        List<Assign> assigns = assignDao.selectAll();
        for (Assign assign: assigns) {
            System.out.println(assign.getCustomer().getName() + ", " + assign.getCustomer().getBirthday().getAge() + ", " + assign.getSurveyor().getId());
        }
    }
}
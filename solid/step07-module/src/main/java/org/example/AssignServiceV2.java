package org.example;

import org.example.assign.Assign;
import org.example.assign.AssignBundle;
import org.example.assign.AssignBundleV2;
import org.example.assign.repository.AssignDao;
import org.example.customer.Customer;
import org.example.customer.repository.CustomerDao;
import org.example.distribute.Distributable;
import org.example.rule.Filterables;
import org.example.rule.Sortables;
import org.example.surveyor.Surveyor;
import org.example.surveyor.repository.SurveyorDao;

import java.util.List;

public class AssignServiceV2 {

    private CustomerDao customerDao;
    private SurveyorDao surveyorDao;
    private AssignDao assignDao;

    public AssignServiceV2(CustomerDao customerDao, SurveyorDao surveyorDao, AssignDao assignDao) {
        //
        this.customerDao = customerDao;
        this.surveyorDao = surveyorDao;
        this.assignDao = assignDao;
    }

    public void assign(Filterables filterables, Sortables sortables, Distributable distributable) {
        //
        List<Customer> customers = this.customerDao.selectAll();
        List<Surveyor> surveyors = this.surveyorDao.selectAll();

        AssignBundleV2 assignBundle = new AssignBundleV2();
        List<Assign> assigns = assignBundle.assign(customers, surveyors, filterables, sortables);
        assignDao.insertAll(assigns);
    }
}


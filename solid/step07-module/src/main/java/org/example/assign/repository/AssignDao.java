package org.example.assign.repository;

import org.example.assign.Assign;

import java.util.ArrayList;
import java.util.List;

public class AssignDao {
    //
    private List<Assign> assigns;

    public AssignDao() {
        //
        this.assigns = new ArrayList<>();
    }
    public void insertAll(List<Assign> assigns) {
        //
        for (Assign assign: assigns) {
            this.assigns.add(assign);
        }
    }

    public List<Assign> selectAll() {
        //
        return this.assigns;
    }
}

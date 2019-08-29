package com.tts.hr;

import java.util.ArrayList;
import java.util.List;

public class HR {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public int getNumEmployees() {
        return employees.size();
    }

    public void hire(Employee e) {
        employees.add(e);
    }

    public double payEverybody() {
        double total = 0.0;
        for (Employee e : employees) {
            System.out.println(e + " is paid " + e.computePay());
            total += e.computePay();

        }
        return total;
    }
}

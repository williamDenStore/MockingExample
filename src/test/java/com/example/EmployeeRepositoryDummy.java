package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepositoryDummy implements EmployeeRepository{
    List<Employee> employees = new ArrayList<>();
    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(e.getId())) {
                employees.set(i, e);
                return e;
            }
        }
        this.employees.add(e);
        return e;
    }
    public EmployeeRepositoryDummy(List<Employee> employees) {
        this.employees.addAll(employees);
    }
}

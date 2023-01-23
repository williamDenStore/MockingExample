package com.example;

import java.util.List;

public class EmployeeRepositoryDummy implements EmployeeRepository{
    List<Employee> employees;
    public void addEmployees(List<Employee> employees){
        this.employees = employees;
    }
    @Override
    public List<Employee> findAll() {
        //List<Employee> employees = List.of(new Employee("123",23), new Employee("43",34));
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}

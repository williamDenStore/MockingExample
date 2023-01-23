package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeesTest {
    //dummy dums
    BankServiceDummy bankServiceDummy = new BankServiceDummy();
    EmployeeRepositoryDummy employeeRepositoryDummy = new EmployeeRepositoryDummy();
    //Mockito mocks
    EmployeeRepository employeeRepositoryMock = mock(EmployeeRepository.class);
    BankService bankServiceMock = mock(BankService.class);
    Employees employeesMock = new Employees(employeeRepositoryMock, bankServiceMock);

    @Test
    void payEmployeesWithListOfTwoEmployeesShouldCallBankServicePayMethodTwice(){
        employeeRepositoryDummy.addEmployees(List.of(new Employee("123",23), new Employee("43",34)));
        Employees employeesDummy = new Employees(employeeRepositoryDummy, bankServiceDummy);

        int actual = employeesDummy.payEmployees();
        int expected = bankServiceDummy.count;

        assertEquals(actual,expected);
    }
    @Test
    void payEmployeesSuccessShouldSetPaidToTrue(){
        List<Employee> employeeList = List.of(new Employee("123",2.5));
        when(employeeRepositoryMock.findAll()).thenReturn(employeeList);

        employeesMock.payEmployees();

        assertTrue(employeeList.get(0).isPaid());
    }
    @Test
    void payEmployeesRunTimeExceptionShouldSetPaidToFalse(){
        List<Employee> employeeList = List.of(new Employee("143",4.2));
        when(employeeRepositoryMock.findAll()).thenReturn(employeeList);

        doThrow(new RuntimeException("Bank service error")).when(bankServiceMock).pay(anyString(), anyDouble());
        employeesMock.payEmployees();
        assertFalse(employeeList.get(0).isPaid());
    }
}
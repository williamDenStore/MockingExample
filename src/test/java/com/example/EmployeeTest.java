package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeTest {

    @ParameterizedTest
    @NullSource
    @CsvSource({"123","abc"})
    void getIdWhenValueIsNumbers(String value) {
        Employee employee = new Employee(value,3.4);

        assertEquals(value,employee.getId());
    }

    @ParameterizedTest
    @NullSource
    @CsvSource({"123","abc"})
    void setIdWhenValueIsNumbers(String value) {
        Employee employee = new Employee("23466123",3.4);
        employee.setId(value);

        assertEquals(value,employee.getId());

    }
    @ParameterizedTest
    @ValueSource(doubles = {1.1,0,-1.3})
    void getSalary(double value) {
        Employee employee = new Employee("123",value);

        assertEquals(value,employee.getSalary());
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.1,0,-1.3})
    void setSalary(double value) {
        Employee employee = new Employee("123",3.2);
        employee.setSalary(value);

        assertEquals(value,employee.getSalary());
    }

    @ParameterizedTest
    @ValueSource(booleans = {true,false})
    void setPaid(boolean value) {
        Employee employee = new Employee("1234",3.9);
        employee.setPaid(value);

        assertEquals(value,employee.isPaid());
    }

    @ParameterizedTest
    @MethodSource("stringAndIntProvider")
    void testToString(String id, double salary) {
        Employee employee = new Employee(id,salary);

        assertEquals("Employee [id=" + id + ", salary=" + salary + "]", employee.toString());
    }
    static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(
                Arguments.of("123", 1.1),
                Arguments.of("abc", 0),
                Arguments.of("abc123", -1.2)
        );
    }

}
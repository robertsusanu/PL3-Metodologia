package Ejercicio_1.primero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {
    Employee emp = new Employee(1,"Señor","X",10);

    @Test
    void getId() {
        assertEquals(1,emp.getId());
    }

    @Test
    void getFirstName() {
        assertEquals("Señor",emp.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("X",emp.getLastName());
    }

    @Test
    void getName() {
        assertEquals("Señor X",emp.getName());
    }

    @Test
    void getSalary() {
        assertEquals(10,emp.getSalary());
    }

    @Test
    void setSalary() {
        emp.setSalary(20);
        assertEquals(20,emp.getSalary());
    }

    @Test
    void getAnnualSalary() {
        assertEquals(120,emp.getAnnualSalary());
    }

    @Test
    void raiseSalary() {
        emp.raiseSalary(10);
        assertEquals(11,emp.getSalary());
    }

    @Test
    void testToString() {
        assertEquals("Employee[id= 1,name= Señor X,salary= 10]",emp.toString());
    }
}
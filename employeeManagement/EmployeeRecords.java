package org.records;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class EmployeeRecords implements Serializable {
    static List<Employee> employees = new ArrayList<>();

    public EmployeeRecords() {

    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void setEmployees( List<Employee> listE) {
        employees=listE;

    }
}
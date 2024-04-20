package org.records;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

abstract class Employee implements Serializable{
    private String pesel;
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    public Employee(String pesel, String firstName, String lastName, BigDecimal salary) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;



    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        if (verifyPeselChecksum(pesel)) {
            this.pesel = pesel;

        } else {
            throw new IllegalArgumentException("Invalid PESEL or already exists");
        }
    }

    private boolean verifyPeselChecksum(String pesel) {
        char[] peselDigits = pesel.toCharArray();
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int digit = Character.getNumericValue(peselDigits[i]);
            sum += i % 4 == 0 ? digit : i % 4 == 1 ? digit * 3 : i % 4 == 2 ? digit * 7 : digit * 9;
        }

        return sum % 10 == 0;
    }

    boolean isPeselArledyExist(String newpesel){

        for(Employee e: EmployeeRecords.employees) {

            if(Objects.equals(pesel, newpesel)){
                return true;
            }

        }

        return false;

    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = BigDecimal.valueOf(salary);
    }

    public abstract void displayInformation();
}
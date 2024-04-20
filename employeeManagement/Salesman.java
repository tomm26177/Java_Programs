package org.records;

import java.math.BigDecimal;
import java.io.Serializable;

class Salesman extends Employee implements Serializable{
    private String workPhone;
    private BigDecimal commissionRate;
    private BigDecimal commissionLimit;

    // Constructor
    public Salesman(String pesel, String firstName, String lastName, BigDecimal salary,
                    String workPhone, BigDecimal commissionRate, BigDecimal commissionLimit) {
        super(pesel, firstName, lastName, salary);
        this.workPhone = workPhone;
        this.commissionRate = commissionRate;
        this.commissionLimit = commissionLimit;
    }

    // Implementation of the abstract method from the base class
    @Override
    public void displayInformation() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Identyfikator PESEL : " + getPesel());
        System.out.println("Imię : " + getFirstName());
        System.out.println("Nazwisko : " + getLastName());
        System.out.println("Wynagrodzenie (zł) : " + getSalary());
        System.out.println("Telefon służbowy numer : " + workPhone);
        System.out.println("Prowizja (%) : " + commissionRate);
        System.out.println("Limit prowizji/miesiąc (zł) : " + commissionLimit);
        System.out.println("------------------------------------------------------------------");
    }
}
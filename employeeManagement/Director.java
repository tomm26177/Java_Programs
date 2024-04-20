package org.records;

import java.math.BigDecimal;
import java.io.Serializable;
public class Director extends Employee implements Serializable{

    private String workPhone;
    private BigDecimal additionalAllowance;
    private String companyCardNumber;
    private BigDecimal costLimit;


    public Director(String pesel, String firstName, String lastName, BigDecimal salary,
                    String workPhone, BigDecimal additionalAllowance, String companyCardNumber, BigDecimal costLimit) {
        super(pesel, firstName, lastName, salary);
        this.workPhone = workPhone;
        this.additionalAllowance = additionalAllowance;
        this.companyCardNumber = companyCardNumber;
        this.costLimit = costLimit;
    }

    @Override
    public void displayInformation() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Identyfikator PESEL : " + getPesel());
        System.out.println("Imię : " + getFirstName());
        System.out.println("Nazwisko : " + getLastName());
        System.out.println("Wynagrodzenie (zł) : " + getSalary());
        System.out.println("Telefon służbowy numer : " + workPhone);
        System.out.println("Dodatek służbowy (zł) : " + additionalAllowance);
        System.out.println("Karta służbowa numer : " + companyCardNumber);
        System.out.println("Limit kosztów/miesiąc (zł) : " + costLimit);
        System.out.println("------------------------------------------------------------------");
    }
}

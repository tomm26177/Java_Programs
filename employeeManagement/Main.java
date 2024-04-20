package org.records;
import java.io.Serializable;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

// działajacy pesel 89063012348


        EmployeeRecords.employees.add(new Director("2020", "Mariusz", "Kowal", BigDecimal.valueOf(15000),
                "501122122", BigDecimal.valueOf(5000), "672-657-68-211", BigDecimal.valueOf(25000)));

        EmployeeRecords.employees.add(new Director("1234", "Maciek", "Kos", BigDecimal.valueOf(12000),
                "501123456", BigDecimal.valueOf(4000), "123-456-78-901", BigDecimal.valueOf(20000)));

        EmployeeRecords.employees.add(new Salesman("5678", "Tomasz", "Karolak", BigDecimal.valueOf(8000),
                "501654321", BigDecimal.valueOf(8), BigDecimal.valueOf(2000)));

        EmployeeRecords.employees.add(new Salesman("9876", "Borys", "Szyc", BigDecimal.valueOf(10000),
                "501987654", BigDecimal.valueOf(10), BigDecimal.valueOf(3000)));

        EmployeeRecords.employees.add(new Director("1111", "Paweł", "Ztarsu", BigDecimal.valueOf(18000),
                "501111222", BigDecimal.valueOf(6000), "111-222-33-444", BigDecimal.valueOf(30000)));


Menu menu = new Menu();
menu.displayMainMenu();
    }
}
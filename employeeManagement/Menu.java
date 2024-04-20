package org.records;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.io.Serializable;
public class Menu {
    private EmployeeRecords employeeRecords = new EmployeeRecords();
    private Backup backupManager = new Backup(employeeRecords);

    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("MENU");
            System.out.println("1. Lista pracowników");
            System.out.println("2. Dodaj pracownika");
            System.out.println("3. Usuń pracownika");
            System.out.println("4. Kopia zapasowa");
            System.out.println("Wybór>");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayEmployeeList();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    displayBackupMenu();
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private void displayEmployeeList() {
        System.out.println("LISTA PRACOWNIKÓW");

        int position = 1;
        for (Employee employee : employeeRecords.getEmployees()) {
            System.out.println("[Pozycja: " + position + "/" + employeeRecords.getEmployees().size() + "]");
            employee.displayInformation();
            System.out.println("[Enter] – następny");
            System.out.println("[Q] – powrót");

            String input = new Scanner(System.in).nextLine();
            if ("Q".equalsIgnoreCase(input)) {
                break;
            } else if ("".equals(input.trim())) {
                position++;
            }
        }
    }

    private void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DODAJ PRACOWNIKA");
        System.out.println("[D]yrektor/[H]handlowiec: ");
        String choice = scanner.nextLine();

        Employee newEmployee;
        if ("D".equalsIgnoreCase(choice)) {
            newEmployee = createDirector();
        } else if ("H".equalsIgnoreCase(choice)) {
            newEmployee = createSalesperson();
        } else {
            System.out.println("Nieprawidłowy wybór. Powrót do menu głównego.");
            return;
        }


        employeeRecords.addEmployee(newEmployee);
        System.out.println("Pracownik dodany pomyślnie.");
    }

    private Director createDirector() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("DODAJ DYREKTORA");
        System.out.println("Identyfikator PESEL: ");
        String pesel = scanner.nextLine();

        if (pesel.length() != 11) {
            throw new IllegalArgumentException("PESEL musi mieć 11 znaków");
        }

        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};
        int sum = 0;

        for (int i = 0; i < 11; i++) {
            sum += Integer.parseInt(pesel.substring(i, i + 1)) * weights[i];
        }

        if (!(sum % 10 == 0)) {
            throw new IllegalArgumentException("Nieprawidłowy PESEL");
        }

        for (Employee employee : EmployeeRecords.employees) {
            if (employee.getPesel().equals(pesel)) {
                throw new IllegalArgumentException("PESEL jest już zajęty");
            }
        }



        System.out.println("Imię: ");
        String firstName = scanner.nextLine();

        System.out.println("Nazwisko: ");
        String lastName = scanner.nextLine();

        System.out.println("Wynagrodzenie (zł): ");
        BigDecimal salary = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.println("Telefon służbowy numer: ");
        String workPhone = scanner.nextLine();

        System.out.println("Dodatek służbowy (zł): ");
        BigDecimal additionalAllowance = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.println("Karta służbowa numer: ");
        String companyCardNumber = scanner.nextLine();

        System.out.println("Limit kosztów/miesiąc (zł): ");
        BigDecimal costLimit = scanner.nextBigDecimal();
        scanner.nextLine();


        return new Director(pesel, firstName, lastName, salary, workPhone, additionalAllowance, companyCardNumber, costLimit);
    }

    private Salesman createSalesperson() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("DODAJ HANDLOWCA");
        System.out.println("Identyfikator PESEL: ");
        String pesel = scanner.nextLine();

        if (pesel.length() != 11) {
            throw new IllegalArgumentException("PESEL musi mieć 11 znaków");
        }

        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};
        int sum = 0;

        for (int i = 0; i < 11; i++) {
            sum += Character.getNumericValue(pesel.charAt(i)) * weights[i];
        }

        if (!(sum % 10 == 0)) {
            throw new IllegalArgumentException("Nieprawidłowy PESEL"+ sum);
        }

        for (Employee employee : EmployeeRecords.employees) {
            if (employee.getPesel().equals(pesel)) {
                throw new IllegalArgumentException("PESEL jest już zajęty");
            }
        }

        System.out.println("Imię: ");
        String firstName = scanner.nextLine();

        System.out.println("Nazwisko: ");
        String lastName = scanner.nextLine();

        System.out.println("Wynagrodzenie (zł): ");
        BigDecimal salary = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.println("Telefon służbowy numer: ");
        String workPhone = scanner.nextLine();

        System.out.println("Prowizja (%): ");
        BigDecimal commissionRate = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.println("Limit prowizji/miesiąc (zł): ");
        BigDecimal commissionLimit = scanner.nextBigDecimal();
        scanner.nextLine();

        return new Salesman(pesel, firstName, lastName, salary, workPhone, commissionRate, commissionLimit);
    }


    private void removeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("USUŃ PRACOWNIKA");
        System.out.println("Podaj Identyfikator PESEL: ");
        String pesel = scanner.nextLine();

        boolean isExist=true;

        for (Employee e : EmployeeRecords.employees) {
            if (e.getPesel().equals(pesel)) {

                EmployeeRecords.employees.remove(e);

                isExist=true;
                break;
            } else {
                isExist = false;
            }
        }

        if (isExist) {
            System.out.println("Pracownik usunięty pomyślnie.");
        }else {
            System.out.println("Nie ma takiego pracownika.");

        }

    }

    private void displayBackupMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("KOPiA ZAPASOWA");
        System.out.println("[Z]achowaj/[O]dtwórz : ");
        String choice = scanner.nextLine();

        if ("Z".equalsIgnoreCase(choice)) {
            createBackup();
        } else if ("O".equalsIgnoreCase(choice)) {
            restoreBackup();
        } else {
            System.out.println("Nieprawidłowy wybór. Powrót do menu głównego.");
        }
    }

    private void createBackup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zachowaj Kompresja [G]zip/[Z]ip : ");
        String compressionChoice = scanner.nextLine();
        System.out.println("Nazwa pliku: ");
        String fileName = scanner.nextLine();


        backupManager.createBackup(fileName, compressionChoice);
        System.out.println("Kopia zapasowa utworzona pomyślnie.");
    }

    private void restoreBackup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Odtwórz");
        System.out.println("Nazwa pliku: ");
        String fileName = scanner.nextLine();
        backupManager.restoreBackup(fileName);
        System.out.println("Kopia zapasowa przywrócona pomyślnie.");
    }
}

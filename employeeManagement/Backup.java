package org.records;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipInputStream;

public class Backup implements Serializable {
    private EmployeeRecords employeeRecords;

    public Backup(EmployeeRecords e) {
        employeeRecords = e;
    }

    public void createBackup(String fileName, String compressionChoice) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            OutputStream outputStream;

            if ("G".equalsIgnoreCase(compressionChoice)) {
                outputStream = new GZIPOutputStream(fileOutputStream);
            } else {
                outputStream = fileOutputStream;
            }

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(employeeRecords.getEmployees());
            objectOutputStream.close();

            System.out.println("Backup created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreBackup(String fileName) {
        try {
            File file = new File(fileName);

            if (!file.exists() || file.length() == 0) {
                System.out.println("Invalid backup file 1.");
                return;
            }

            System.out.println("File size: " + file.length() + " bytes");

            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream inputStream;

            if (fileName.endsWith(".gz")) {
                System.out.println("Using GZIP decompression.");
                inputStream = new GZIPInputStream(fileInputStream);
            } else {
                System.out.println("No compression detected.");
                inputStream = fileInputStream;
            }

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);


            List<Employee> restoredEmployees = (List<Employee>) objectInputStream.readObject();
            objectInputStream.close();

            employeeRecords.setEmployees(restoredEmployees);

            System.out.println("Backup restored successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed to restore backup.");
        }
    }




}

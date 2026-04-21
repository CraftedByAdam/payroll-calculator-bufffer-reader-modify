package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {
        String fileName = "employees.csv";

        try {
            Scanner scanner = new Scanner(System.in);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            System.out.print("Enter the name of the file employee to process: ");
            String nameOfFileEmployee = scanner.next();
            System.out.print("Enter the name of the payroll file to create: ");
            String payrollFileName = scanner.next();

            bufferedWriter.write(nameOfFileEmployee);
            bufferedWriter.newLine();
            bufferedWriter.write(payrollFileName);
            bufferedWriter.close();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
        }
    }
}

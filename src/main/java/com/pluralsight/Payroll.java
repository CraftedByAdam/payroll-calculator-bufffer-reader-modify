package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the file you want to copy from: ");
        String nameOfFile = scanner.nextLine();
        System.out.println("Enter the the name  of the file you want to copy to: ");
        String nameOfFile2 = scanner.nextLine();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(nameOfFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameOfFile,true));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                //outputLine = String.format("Employee ID: %d, Name: %s, Gross Pay: $%.2f%n");


               /* System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());*/
            }
            reader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + nameOfFile);
        }
    }
}

package com.bridgeLabz;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayRollService {

    static ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();

    public static void main(String[] args) {

        Scanner consoleInputReader = new Scanner(System.in);


        EmployeePayRollService.readEmployeePayRollData(consoleInputReader);
        EmployeePayRollService.writeEmployeePayRollData();
    }
    private static void readEmployeePayRollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary");
        double salary = consoleInputReader.nextDouble();

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));

    }


    private static void writeEmployeePayRollData() {
        System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
    }
}

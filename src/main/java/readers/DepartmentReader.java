package readers;

import model.Department;
import model.Employee;

import java.util.Scanner;

public class DepartmentReader {
    private final Scanner sc;
    private final EmployeeReader employeeReader;


    public DepartmentReader(Scanner sc, EmployeeReader employeeReader) {
        this.sc = sc;
        this.employeeReader = employeeReader;
    }

    public Department read() {
        System.out.println("Introduce los datos del departamento");
        System.out.println("Nombre:");
        String name = sc.nextLine();

        System.out.println("Presupuesto:");
        double budget = sc.nextDouble();
        sc.nextLine();

        int numEmployees;
        do {
            System.out.println("¿Cuántos empleados componen este departamento?");
            numEmployees = sc.nextInt();
            sc.nextLine();
        } while (numEmployees < 1);

        Employee[] employees = new Employee[numEmployees];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = employeeReader.read();
        }

        return new Department(
                name,
                budget,
                employees
        );
    }
}

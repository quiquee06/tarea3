package apps;

import model.Company;
import model.Department;
import readers.CompanyReader;


import java.util.Scanner;

public class CompanyApp {
    private final Scanner sc;
    private final CompanyReader companyReader;

    public CompanyApp(Scanner sc, CompanyReader companyReader) {
        this.sc = sc;
        this.companyReader = companyReader;
    }

    public void run() {
        Company company = companyReader.read();

        int opt;
        do {
            System.out.println("Introduce una opción");
            System.out.println("1. Mostrar datos de un departamento");
            System.out.println("2. Mostrar empleados de un departamento");
            System.out.println("3. Mostrar los datos de un empleado de un departamento");
            System.out.println("4. Salir");
            opt = sc.nextInt();
            sc.nextLine();

            if (opt == 1) {
                showDepartmentInfoByName(company);
            }
        } while (opt != 4);
    }

    private void showDepartmentInfoByName(Company company) {
        System.out.println("Introduce el nombre del departamento");
        String name = sc.nextLine();

        Department department = company.findDepartment(name);
        if (department.getName().equals(name)) {
            department.showInfo();
        } else {
            System.out.println("No se encuentra el departamento");
        }
    }
}

package readers;

import model.Company;
import model.Department;

import java.util.Scanner;

public class CompanyReader {
    private final Scanner sc;
    private DepartmentReader departmentReader;

    public CompanyReader(Scanner sc, DepartmentReader departmentReader) {
        this.sc = sc;
        this.departmentReader = departmentReader;
    }

    public Company read() {
        System.out.println("Introduce los datos de la empresa");
        System.out.println("Nombre:");
        String name = sc.nextLine();

        System.out.println("Introduce el CIF:");
        String cif = sc.nextLine();

        int numDepartments;
        do {
            System.out.println("¿Cuántos departamentos componen esta empresa?");
            numDepartments = sc.nextInt();
            sc.nextLine();
        } while (numDepartments < 1);

        Department[] departments = new Department[numDepartments];
        for (int i = 0; i < departments.length; i++) {
            departments[i] = departmentReader.read();
        }

        return new Company(
                name,
                cif,
                departments
        );
    }
}

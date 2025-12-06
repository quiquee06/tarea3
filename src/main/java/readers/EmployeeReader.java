package readers;

import model.Employee;

import java.util.Scanner;

public class EmployeeReader {
    private final Scanner sc;

    public EmployeeReader(Scanner sc) {
        this.sc = sc;
    }

    public Employee read() {
        System.out.println("Introduce los datos del empleado");
        System.out.println("NIF:");
        String nif = sc.nextLine();

        System.out.println("Nombre:");
        String name = sc.nextLine();

        System.out.println("Apellidos:");
        String surname = sc.nextLine();

        System.out.println("Puesto");
        String position = sc.nextLine();

        return new Employee(
                nif,
                name,
                surname,
                position
        );
    }
}

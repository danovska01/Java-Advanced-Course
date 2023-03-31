package _12_DefiningClasses_Ex._2_CompanyRoster;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Department> departmentsMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            //Peter 120.00 Dev Development peter@abv.bg 28
            String [] tokens = scanner.nextLine().split(" ");

            String nameEmployee = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String nameOfTheDepartment = tokens[3];
            Department currentDepartment;

            if (!departmentsMap.containsKey(nameOfTheDepartment)) {
                currentDepartment = new Department(nameOfTheDepartment);
                departmentsMap.put(nameOfTheDepartment, currentDepartment);
            } else {
                currentDepartment = departmentsMap.get(nameOfTheDepartment);
            }

            Employee employee = null;
            if (tokens.length == 4) {
                employee = new Employee(nameEmployee, salary, position, currentDepartment);
            } else if (tokens.length == 5) {
                try {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(nameEmployee, salary, position, currentDepartment, age);
                } catch (NumberFormatException e) {
                    String email = tokens[4];
                    employee = new Employee(nameEmployee, salary, position, currentDepartment, email);
                }
            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(nameEmployee, salary, position, currentDepartment, email, age);
            }
            departmentsMap.get(nameOfTheDepartment).getEmployeeList().add(employee);
        }

        //Calculate the department with the highest average salary and prints for each employee in that department

        List<Employee> employeeList = departmentsMap.entrySet().stream()
                .sorted((employee1, employee2) -> {
                    double salary1 = employee1.getValue().getEmployeeList().stream().mapToDouble(Employee::getSalary).sum();
                    double salary2 = employee2.getValue().getEmployeeList().stream().mapToDouble(Employee::getSalary).sum();
                    return Double.compare(salary2, salary1);
                })
                .map(emp -> emp.getValue().getEmployeeList())
                .findFirst().orElse(null);

        System.out.printf("Highest Average Salary: %s%n", employeeList.get(0).getDepartment().getName());

        //sorted by salary in descending order.
        employeeList.stream().sorted((employee1, employee2) -> Double.compare(employee2.getSalary(), employee1.getSalary()))
                .forEach(emp -> {
                    System.out.printf("%s %.2f %s %d%n",
                            emp.getName(),
                            emp.getSalary(),
                            emp.getEmail(),
                            emp.getAge());
                });



    }
}

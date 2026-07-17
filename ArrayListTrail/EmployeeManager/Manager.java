package EmployeeManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Manager {
    private ArrayList<Employee> employees;

    public Manager() {
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployee() {
        return employees;
    }

    public void add(Employee e) {
        if (e == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }
        for (Employee employee : employees) {
            if (employee.getId().equalsIgnoreCase(e.getId())) {
                throw new IllegalArgumentException("Employee ID already exists.");
            }
        }
        employees.add(e);
    }

    public void display() {
        if (employees.isEmpty()) {
            System.out.println("No employees.");
            return;
        }

        System.out.printf("%-10s %-20s %-20s %-15s %-10s%n",
                             "ID", "Name", "Position", "Salary", "Exp");
        System.out.println("---------------------------------------------------------------------------");
        for (Employee e : employees) {
            System.out.printf("%-10s %-20s %-20s %-15.2f %-10d%n",
                    e.getId(), e.getName(), e.getPosition(), e.getSalary(), e.getExperiance());
        }
    }

    public int findIndex(String input) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equalsIgnoreCase(input)
                    || employees.get(i).getName().equalsIgnoreCase(input)) {
                return i;
            }
        }
        return -1;
    }

    public Employee findEmployee(String input) {
        int index = findIndex(input);
        if (index >= 0) {
            return employees.get(index);
        }
        return null;
    }

    public boolean update(String id, String name, String position, double salary, int experiance) {
        int index = findIndex(id);
        if (index >= 0) {
            Employee e = employees.get(index);
            e.setName(name);
            e.setPosition(position);
            e.setSalary(salary);
            e.setExperiance(experiance);
            return true;
        }
        return false;
    }

    public boolean delete(String input) {
        int index = findIndex(input);
        if (index >= 0) {
            employees.remove(index);
            return true;
        }
        return false;
    }

    public void sortBySalary(boolean ascending) {
        if (employees.size() < 2) {
            return;
        }
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (ascending) {
                    return Double.compare(e1.getSalary(), e2.getSalary());
                }
                return Double.compare(e2.getSalary(), e1.getSalary());
            }
        });
    }

    public void sortByExperienceDescending() {
        if (employees.size() < 2) {
            return;
        }
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e2.getExperiance(), e1.getExperiance());
            }
        });
    }

    public void displayEmployeesBySalary() {
        if (employees.isEmpty()) {
            System.out.println("No employees.");
            return;
        }

        Employee highest = employees.get(0);
        Employee lowest = employees.get(0);

        for (Employee e : employees) {
            if (e.getSalary() > highest.getSalary()) {
                highest = e;
            }
            if (e.getSalary() < lowest.getSalary()) {
                lowest = e;
            }
        }

        System.out.print("Highest salary employee: ");
        System.out.println(highest);
        System.out.print("Lowest salary employee: ");
        System.out.println(lowest);
    }

    public double avgSalary() {
        if (employees.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Employee e : employees) {
            sum += e.getSalary();
        }
        return sum / employees.size();
    }
}

package EmployeeManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
        sc.close();
    }

    // Ham check lua chon nhap vao
    public static boolean isInteger(String input) {
        if (input.length() <= 0) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }

    public static int checkChoice(Scanner sc, String mess) {
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine().trim();
            if (!isInteger(input)) {
                System.out.println("Please enter integer.");
                continue;
            }
            int number = 0;
            for (int i = 0; i < input.length(); i++) {
                number = number * 10 + (input.charAt(i) - '0');
            }
            return number;
        }
    }

    public static void menu(Scanner sc) {
        Manager m = new Manager();
        try {
            m.add(new Employee("HE204576", "Anh", "Intern", 2000000, 0));
            m.add(new Employee("HE200000", "Sand", "Manager", 40000000, 5));
            m.add(new Employee("HE204679", "Tho", "Developer", 20000000, 3));
            m.add(new Employee("HE245678", "Ngan", "HR (Human Resources)", 7000000, 2));
            m.add(new Employee("HE345678", "Dand", "Tester", 20000000, 4));
        } catch (IllegalArgumentException e) {
            System.out.println("Initial sample data error: " + e.getMessage());
        }
        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Add Employee.");
            System.out.println("2. Display Employees.");
            System.out.println("3. Search Employee by Name or Id.");
            System.out.println("4. Update or Delete Employee.");
            System.out.println("5. Sort Employees by salary (inc or deinc).");
            System.out.println("6. Sort Employees by experience (deinc)");
            System.out.println("7. Display Employees by salary (highest and lowest).");
            System.out.println("8. Calculate average Salary.");
            System.out.println("9. Exit.");

            int choice = checkChoice(sc, "Enter choice: ");

            switch (choice) {
                case 1:
                    addEmployee(sc, m);
                    break;
                case 2:
                    m.display();
                    break;
                case 3:
                    findEmployee(sc, m);
                    break;
                case 4:
                    updateOrDelete(sc, m);
                    break;
                case 5:
                    sortBySalary(sc, m);
                    break;
                case 6:
                    sortByExperience(sc, m);
                    break;
                case 7:
                    m.displayEmployeesBySalary();
                    break;
                case 8:
                    showAverageSalary(m);
                    break;
                case 9:
                    System.out.println("GoodBye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid!");
                    break;
            }
        }
    }

    public static void addEmployee(Scanner sc, Manager m) {
        System.out.println("===== Information =====");
        while (true) {
            try {
                System.out.print("\nEnter ID: ");
                String id = Validation.validID(sc.nextLine());
                System.out.print("\nEnter name: ");
                String name = Validation.validName(sc.nextLine());
                String position = choosePosition(sc);
                System.out.print("\nEnter salary: ");
                double salary = Validation.validSalary(sc.nextLine());
                System.out.print("\nEnter experience: ");
                int experience = Validation.validExperience(sc.nextLine());

                m.add(new Employee(id, name, position, salary, experience));
                System.out.println("Add Employee Successfully.");
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void findById(Scanner sc, Manager m) {
        System.out.print("Enter id: ");
        String id = Validation.validID(sc.nextLine());

        Employee e = m.findEmployee(id);
        if (e != null) {
            System.out.print("Search results: ");
            System.out.println(e);
        } else {
            System.out.println("Employees not found.");
        }
    }

    public static void findByName(Scanner sc, Manager m) {
        System.out.print("Enter name: ");
        String name = Validation.validName(sc.nextLine());

        Employee e = m.findEmployee(name);
        if (e != null) {
            System.out.print("Search results: ");
            System.out.println(e);
        } else {
            System.out.println("Employees not found.");
        }
    }

    public static void findEmployee(Scanner sc, Manager m) {
        System.out.println("\nDo you want to search by name or id");
        System.out.println("1. Name");
        System.out.println("2. Id");
        int action;
        do {
            action = checkChoice(sc, "Enter choice: ");
            if (action > 2 || action < 1) {
                System.out.println("Error. Please enter again.");
            }
        } while (action > 2 || action < 1);
        if (action == 1) {
            findByName(sc, m);
        } else {
            findById(sc, m);
        }
    }

    public static void updateEmployee(Scanner sc, Manager m) {
        System.out.print("Enter id: ");
        String id = Validation.validID(sc.nextLine());
        Employee exist = m.findEmployee(id);
        if (exist == null) {
            System.out.println("Id employee not found.");
            return;
        }
        try {
            System.out.println("\n===== Update =====");
            System.out.print("\nEnter name: ");
            String name = Validation.validName(sc.nextLine());
            String position = choosePosition(sc);
            System.out.print("\nEnter salary: ");
            double salary = Validation.validSalary(sc.nextLine());
            System.out.print("\nEnter experience: ");
            int experience = Validation.validExperience(sc.nextLine());

            boolean update = m.update(id, name, position, salary, experience);
            if (update) {
                System.out.println("Update Successfully.");
            } else {
                System.out.println("Update fail.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteEmployee(Scanner sc, Manager m) {
        System.out.print("Enter id: ");
        String id = Validation.validID(sc.nextLine());
        Employee exist = m.findEmployee(id);
        if (exist == null) {
            System.out.println("Id employee not found.");
            return;
        }
        boolean delete = m.delete(id);
        if (delete) {
            System.out.println("Delete successfully.");
        } else {
            System.out.println("Delete fail.");
        }
    }

    public static void updateOrDelete(Scanner sc, Manager m) {
        System.out.print("\nDo you want to Update (U) or Delete (D): ");
        String action = sc.nextLine().trim();
        if (action.equalsIgnoreCase("U")) {
            updateEmployee(sc, m);
        } else if (action.equalsIgnoreCase("D")) {
            deleteEmployee(sc, m);
        } else {
            System.out.println("Action invalid. Return Menu.");
        }
    }

    public static void sortBySalary(Scanner sc, Manager m) {
        System.out.println("\n===== Sort by Salary =====");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int choice;
        do {
            choice = checkChoice(sc, "Enter choice: ");
            if (choice > 2 || choice < 1) {
                System.out.println("Error. Enter again!");
            }
        } while (choice > 2 || choice < 1);
        m.sortBySalary(choice == 1);
        m.display();
    }

    public static void sortByExperience(Scanner sc, Manager m) {
        System.out.println("\n===== Sort by Experience =====");
        m.sortByExperienceDescending();
        m.display();
    }

    public static void showAverageSalary(Manager m) {
        System.out.println("Average Salary: " + m.avgSalary());
    }

    // Intern, Developer, Tester, Manager, HR(Human resources)
    public static String choosePosition(Scanner sc) {
        System.out.println("\n===== Choose Position =====");
        System.out.println("1. Manager");
        System.out.println("2. Developer");
        System.out.println("3. Tester");
        System.out.println("4. HR (Human Resources)");
        System.out.println("5. Intern");
        int choice;

        do {
            choice = checkChoice(sc, "Enter choice: ");
            if (choice > 5 || choice < 1) {
                System.out.println("Error. Enter again!");
            }
        } while (choice > 5 || choice < 1);
        if (choice == 1) {
            return "Manager";
        } else if (choice == 2) {
            return "Developer";
        } else if (choice == 3) {
            return "Tester";
        } else if (choice == 4) {
            return "HR (Human resources)";
        } else {
            return "Intern";
        }
    }
}

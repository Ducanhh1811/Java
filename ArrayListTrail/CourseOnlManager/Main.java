package CourseOnlManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
        sc.close();
    }

    // Check choice
    public static boolean isInteger(String input) {
        if (input.length() == 0) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }

    public static int spChoice(Scanner sc, String mess) {
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine().trim();
            if (!isInteger(input)) {
                System.out.println("Please enter Integer");
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
            m.add(new CourseOnl("C001", "Java Programming", "Nguyen Van A", 350.0, 28));
            m.add(new CourseOnl("C002", "Web Development", "Tran Thi B", 420.0, 35));
            m.add(new CourseOnl("C003", "Database Systems", "Hoang Gia E", 300.0, 22));
            m.add(new CourseOnl("C004", "Python for Beginners", "Le Van C", 280.0, 40));
            m.add(new CourseOnl("C005", "Data Structures", "Pham Minh D", 390.0, 18));

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        while (true) {
            System.out.println("=============== Menu ===============");
            System.out.println("1. Add Course");
            System.out.println("2. Display list Course");
            System.out.println("3. Find Course by name or id");
            System.out.println("4. Update or Delete Course");
            System.out.println("5. Sort by price (asc or desc)");
            System.out.println("6. Sort by Student (desc)");
            System.out.println("7. Display Course price highest and lowest");
            System.out.println("8. Display Cource most Students");
            System.out.println("9. Total revenue Course.");
            System.out.println("10. Exit");

            int choice = spChoice(sc, "Enter choose: ");
            switch (choice) {
                case 1:
                    addCourse(sc, m);
                    break;
                case 2:
                    m.display();
                    break;
                case 3:
                    findCourseOnl(sc, m);
                    break;
                case 4:
                    updateOrDelete(sc, m);
                    break;
                case 10:
                    System.out.println("GoodBye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid.");
                    break;
            }
        }
    }

    public static void addCourse(Scanner sc, Manager m) {
        while (true) {
            try {
                System.out.println("===== Add Course Online =====");
                System.out.print("Enter id: ");
                String id = Validation.validId(sc.nextLine());
                System.out.print("Enter name: ");
                String name = Validation.validName(sc.nextLine());
                System.out.print("Enter instructor: ");
                String instructor = Validation.validInstructor(sc.nextLine());
                System.out.print("Enter price: ");
                double price = Validation.validPrice(sc.nextLine());
                System.out.print("Enter enrolled students: ");
                int enrolled = Validation.validEnrolls(sc.nextLine());

                m.add(new CourseOnl(id, name, instructor, price, enrolled));
                System.out.println("Add Course Online Successfully.");
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void findByname(Scanner sc, Manager m) {
        System.out.print("\nEnter name: ");
        String name = Validation.validName(sc.nextLine());
        CourseOnl c = m.findCourseOnl(name);
        if (c != null) {
            System.out.println("Search result: ");
            System.out.println(c);
        } else {
            System.out.println("Id course not found.");
        }
    }

    public static void findById(Scanner sc, Manager m) {
        System.out.print("\nEnter Id: ");
        String id = Validation.validId(sc.nextLine());
        CourseOnl c = m.findCourseOnl(id);
        if (c != null) {
            System.out.println("Search result: ");
            System.out.println(c);
        } else {
            System.out.println("Id course not found.");
        }
    }

    public static void findCourseOnl(Scanner sc, Manager m) {
        System.out.println("Do you want to search by id or name");
        System.out.println("1. Id");
        System.out.println("2. Name");
        int choice;
        do {
            choice = spChoice(sc, "Enter choice: ");
            if (choice > 2 || choice < 1) {
                System.out.println("Invalid choice, Enter again.");
            }
        } while (choice > 2 || choice < 1);
        if (choice == 1) {
            findById(sc, m);
        } else {
            findByname(sc, m);
        }
    }

    public static void updateCourse(Scanner sc, Manager m) {
        System.out.print("Enter id: ");
        String id = Validation.validId(sc.nextLine());
        CourseOnl exist = m.findCourseOnl(id);
        if (exist == null) {
            System.out.println("Id not found.");
            return;
        }
        try {
            System.out.println("\n===== Update =====");
            System.out.print("Enter name: ");
            String name = Validation.validName(sc.nextLine());
            System.out.print("Enter instructor: ");
            String instructor = Validation.validInstructor(sc.nextLine());
            System.out.print("Enter price: ");
            double price = Validation.validPrice(sc.nextLine());
            System.out.print("Enter enrolled students: ");
            int enrolled = Validation.validEnrolls(sc.nextLine());

            boolean update = m.update(id, name, instructor, price, enrolled);
            if (update) {
                System.out.println("Update Successfully.");
            } else {
                System.out.println("Update fail.");
            }
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deteleCourse(Scanner sc, Manager m) {
        System.out.print("\nEnter Id: ");
        String id = Validation.validId(sc.nextLine());
        CourseOnl exist = m.findCourseOnl(id);
        if (exist == null) {
            System.out.println("Id not found.");
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
        System.out.println("Do you want to Update or Delete course.");
        System.out.println("1. Update");
        System.out.println("2. Delete");
        int choice;
        do {
            choice = spChoice(sc, "Enter choice: ");
            if (choice > 2 || choice < 1) {
                System.out.println("Invalid choice, Enter again.");
            }
        } while (choice > 2 || choice < 1);
        if (choice == 1) {
            updateCourse(sc, m);
        } else {
            deteleCourse(sc, m);
        }
    }
}

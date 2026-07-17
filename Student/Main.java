package Student;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
        sc.close();
    }

    public static void menu(Scanner sc) {
        Manager m = new Manager();

        m.addStudent(new Student("01", "A", "java", 3));
        m.addStudent(new Student("02", "B", ".net", 7));
        m.addStudent(new Student("03", "C", "java", 2));
        m.addStudent(new Student("04", "D", "java", 4));
        m.addStudent(new Student("05", "E", ".net", 7));
        m.addStudent(new Student("06", "F", "c/c++", 1));
        m.addStudent(new Student("07", "G", "c/c++", 2));
        m.addStudent(new Student("08", "G", "java", 3));
        m.addStudent(new Student("09", "I", ".net", 5));

        while (true) {
            System.out.println("======Student Manager=====");
            System.out.println("1. Create Student");
            System.out.println("2. Find and sort Student");
            System.out.println("3. Update and delete Student");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter option: ");
            String option = sc.nextLine().trim();
            switch (option) {
                case "1":
                    createStudent(sc, m);
                    break;
                case "2":
                    findAndSortStudent(m, sc);
                    break;
                case "3":
                    updateOrDeleteStudent(m, sc);
                    break;
                case "4":
                    Report.generateAndDisplayReport(m);
                    break;
                case "5":
                    System.out.println("GoodBye!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option! Enter again!!");
                    break;
            }
        }
    }

    public static void createStudent(Scanner sc, Manager m) {
        System.out.println("======Student Infomation======");
        while(true){
            try{
                System.out.print("Enter id: ");
                String id = Validation.validID(sc.nextLine());
                System.out.print("Enter name: ");
                String name = Validation.validName(sc.nextLine());
                String Course = chooseCourse(sc);
                System.out.print("Enter semester: ");
                int semester = Validation.validSemester(sc.nextLine());

                m.addStudent(new Student(id, name, Course, semester));
                System.out.println("Student added successfully. Total Student: " + m.getStudents().size());
                
                System.out.print("Do you want to add more? Yes/No: ");
                String result = sc.nextLine().trim();
                if(!result.equalsIgnoreCase("Yes") && !result.equalsIgnoreCase("Y")){
                    break;
                }
            }catch(IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    public static void updateStudent(Manager m, Scanner sc, String id){
        Student exist = m.findStudentByIdS(id);
        if(exist == null){
            System.out.println("Student not found.");
            return;
        }

        try{
            System.out.print("Enter new student name: ");
            String name = Validation.validName(sc.nextLine());
            String courseName = chooseCourse(sc);
            System.out.print("Enter new semester: ");
            int semester = Validation.validSemester(sc.nextLine());

            boolean updated = m.updateStudent(id, name, courseName, semester);
            if(updated){
                System.out.println("Student updated successfully.");
            }else{
                System.out.println("Update faild.");
            }

        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteStudent(Manager m, Scanner sc){
        System.out.print("Enter student ID to delete: ");
        String id = sc.nextLine().trim();
        boolean removed = m.removeStudent(id);
        if(removed){
            System.out.println("Student removed successfully");
        }else{
            System.out.println("Removed faild.");
        }
    }

    public static void updateOrDeleteStudent(Manager m, Scanner sc){
        System.out.println("Enter student id to find: ");
        String id = sc.nextLine().trim();
        Student student = m.findStudentByIdS(id);
        if(student == null){
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Found: " + student);
        System.out.print("Do you want to update (U) or delete (D) student? ");
        String action = sc.nextLine().trim();
        if(action.equalsIgnoreCase("U")){
            updateStudent(m, sc, id);
        }else if(action.equalsIgnoreCase("D")){
            deleteStudent(m, sc);
        }else{
            System.out.println("Invalid action. Returning to main menu.");
        }
    }

    public static void findAndSortStudent(Manager m, Scanner sc){
        if(m.getStudents().isEmpty()){
            System.out.println("No students available.");
            return;
        }

        System.out.print("Enter student name or part of name to search: ");
        String search = sc.nextLine().trim().toLowerCase();
        List<Student> matched = new ArrayList<>();
        for(Student s : m.getStudents()){
            if(s.getName().toLowerCase().contains(search)){
                matched.add(s);
            }
        }

        if(matched.isEmpty()){
            System.out.println("No student found matching the search.");
            return;
        }

        Collections.sort(matched, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2){
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });

        System.out.println("\n--- Find and Sort Results ---");
        System.out.format("%-25s | %-10s | %-10s%n", "Name", "Semester", "Course");
        for (Student s : matched) {
            System.out.format("%-25s | %-10s | %-10s%n", s.getName(), s.getSemester(), s.getCourse());
        }
    }

    public static String chooseCourse(Scanner sc) {
        System.out.println("===Choose Course===");
        System.out.println("1. .net");
        System.out.println("2. java");
        System.out.println("3. c/c++");

        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice > 3 || choice < 1) {
                System.out.println("Choice must between (1, 3)!");
            }
        } while (choice > 3 || choice < 1);
        if (choice == 1) {
            return ".net";
        }
        if (choice == 2) {
            return "java";
        } else {
            return "c/c++";
        }
    }
}

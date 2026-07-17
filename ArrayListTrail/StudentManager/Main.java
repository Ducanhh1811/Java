package StudentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
        sc.close();
    }

    public static void menu(Scanner sc){
        Manager m = new Manager();
        System.out.println();
        System.out.println("========== Menu ===========");
        while(true){
            System.out.println("1. Add Student.");
            System.out.println("2. Display Student.");
            System.out.println("3. Search Student (ID).");
            System.out.println("4. Update Student.");
            System.out.println("5. Remove Student.");
            System.out.println("6. Exit.");

            System.out.print("Enter choose: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch(choose){
                case 1:
                    addStudent(sc, m);
                    break;
                case 2:
                    m.display();
                    break;
                case 3:
                    searchStudent(sc, m);
                    break;
                case 4:
                    updateStudent(sc, m);
                    break;
                case 5:
                    deleteStudent(sc, m);
                    break;
                case 6:
                    System.out.println("GOODBYE!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    public static void addStudent(Scanner sc, Manager m){
        System.out.println("====== Student Info ======");
        while(true){
            try{
                System.out.print("Enter id: ");
                String id = Validation.validID(sc.nextLine());
                System.out.print("Enter name: ");
                String name = Validation.validName(sc.nextLine());
                System.out.print("Enter GPA: ");
                float gpa = Validation.validGPA(sc.nextLine());

                m.addStuden(new Student(id, name, gpa));
                System.out.println("Add student successfully.");
                return;
            }catch(IllegalArgumentException e){
                System.out.println("Error : " + e.getMessage());
            }
        }
    }

    public static void searchStudent(Scanner sc, Manager m){
        System.out.print("Enter id: ");
        String id = Validation.validID(sc.nextLine());

        Student s = m.searchStudentByID(id);
        if(s != null){
            System.out.println("Search result:");
            System.out.println(s);
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void update(Scanner sc, Manager m, String id){
        Student exist = m.searchStudentByID(id);
        if(exist == null){
            System.out.println("Student not found.");
            return;
        }
        try{
            System.out.print("Enter name: ");
            String name = Validation.validName(sc.nextLine());
            System.out.print("Enter gpa: ");
            float gpa = Validation.validGPA(sc.nextLine());

            boolean update = m.update(id, name, gpa);
            if(update){
                System.out.println("Update successfully.");
            }else{
                System.out.println("Update fail.");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void updateStudent(Scanner sc, Manager m){
        System.out.print("Enter student ID to update: ");
        String id = sc.nextLine().trim();
        Student s = m.searchStudentByID(id);
        if(s == null){
            System.out.println("Student not found.");
            return;
        }
        update(sc, m, id);
    }

    public static void deleteStudent(Scanner sc, Manager m){
        System.out.print("Enter student ID to delete: ");
        String id = sc.nextLine().trim();
        Student s = m.searchStudentByID(id);
        if(s == null){
            System.out.println("Student not found.");
            return;
        }
        boolean delete = m.delete(id);
        if(delete){
            System.out.println("Delete student successfully.");
        }else{
            System.out.println("Delete fail.");
        }
    }
}

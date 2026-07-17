package ManagerSubject;

import java.util.Scanner;

// ========== MENU ==========
// 1. Add subject
// 2. Display subjects
// 3. Search subject
// 4. Remove subject
// 5. Exit
// Choose:

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
        sc.close();
    }

    public static void menu(Scanner sc){
        Manager m = new Manager();
        while(true){
            System.out.println("========== MENU ==========");
            System.out.println("1. Add subject");
            System.out.println("2. Display subjects");
            System.out.println("3. Search subject");
            System.out.println("4. Remove subject");
            System.out.println("5. Exit");
            System.out.print("Enter choose: ");
            int choose = sc.nextInt();
            sc.nextLine();

            switch (choose){
                case 1:
                    addSubject(sc, m);
                    break;
                case 2:
                    m.display();
                    break;
                case 3:
                    searchSubject(sc, m);
                    break;
                case 4:
                    deleteSubject(sc, m);
                    break;
                case 5:
                    System.out.println("GoodBye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    public static void addSubject(Scanner sc, Manager m){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        m.addSubject(new Subject(name));
    }

    public static void deleteSubject(Scanner sc, Manager m){
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        m.removeSubject(name);
    }

    public static void searchSubject(Scanner sc, Manager m){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        m.searchName(name);
    }
}

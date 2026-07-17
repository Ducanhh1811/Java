package FruitManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
        sc.close();
    }

    public static void menu(Scanner sc){
        Manager m = new Manager();
        while(true){
            System.out.println("====== Menu ======");
            System.out.println("1. Add Fruit");
            System.out.println("2. Remove Fruit");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1: 
                    addFruit(sc, m);
                    break;
                case 2:
                    removeFruit(sc, m);
                    break;
                case 3:
                    m.display();
                    break;
                case 4: 
                    System.out.println("GoodBye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid.");
                    break;
            }
            
        }
    }

    public static void addFruit(Scanner sc, Manager m){
        System.out.print("\nEnter fruit: ");
        String name = sc.nextLine();
        m.addFruit(new Fruit(name));
    }

    public static void removeFruit(Scanner sc, Manager m){
        System.out.print("\nEnter name: ");
        String nameFruit = sc.nextLine();
        m.removeFruit(nameFruit);
    }
}

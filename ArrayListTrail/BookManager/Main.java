package BookManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
        sc.close();
    }

    public static void menu(Scanner sc){
        Manager m = new Manager();
        System.out.println("===== Menu =====");

        while(true){
            System.out.println("1. Add Book.");
            System.out.println("2. Display Book.");
            System.out.println("3. Search Book (ID).");
            System.out.println("4. Update and Delete Book.");
            System.out.println("5. Exit.");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    addBook(sc, m);
                    break;
                case 2:
                    m.display();
                    break;
                case 3:
                    searchBook(sc, m);
                    break;
                case 4:
                    updateAndDelete(sc, m);
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

    public static void addBook(Scanner sc, Manager m){
        while(true){
            try{
                System.out.println("===== INFO =====");
                System.out.print("Enter id: ");
                String id = Validation.validId(sc.nextLine());
                System.out.print("Enter title: ");
                String title = Validation.validTitle(sc.nextLine());
                System.out.print("Enter author: ");
                String author = Validation.validAuthor(sc.nextLine());
                System.out.print("Enter quantity: ");
                int quantity = Validation.validQuantity(sc.nextLine());

                m.add(new Book(id, title, author, quantity));
                System.out.println("Add book succesfully.");
                return;
            }catch(IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void searchBook(Scanner sc, Manager m){
        System.out.print("Enter id: ");
        String id = Validation.validId(sc.nextLine());
        Book b = m.findBookById(id);
        if(b != null){
            System.out.println("Search result");
            System.out.println(b);
        }else{
            System.out.println("Not found.");
        }
    }

    public static void updateBook(Scanner sc, Manager m){
        System.out.print("Enter id to update: ");
        String id = sc.nextLine().trim();
        Book exist = m.findBookById(id);
        if(exist == null){
            System.out.println("Id Book not found.");
            return;
        }
        try{
            System.out.print("Enter title: ");
            String title = Validation.validTitle(sc.nextLine());
            System.out.print("Enter author: ");
            String author = Validation.validAuthor(sc.nextLine());
            System.out.print("Enter quantity: ");
            int quantity = Validation.validQuantity(sc.nextLine());
                
            boolean update = m.update(id, title, author, quantity);
            if(update){
                System.out.println("Update successfully.");
            }else{
                System.out.println("Update fail.");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteBook(Scanner sc, Manager m){
        System.out.print("Enter id to delete: ");
        String id = sc.nextLine().trim();
        Book exist = m.findBookById(id);
        if(exist == null){
            System.out.println("Id Book not found.");
            return;
        }
        boolean delete = m.delete(id);
        if(delete){
            System.out.println("Delete successfully.");
        }else{
            System.out.println("Delete fail.");
        }
    }

    public static void updateAndDelete(Scanner sc, Manager m){
        System.out.print("Do you want to Delete or Update Book (D/U): ");
        String choose = sc.nextLine().trim().toUpperCase();
        if(choose.equals("D")){
            deleteBook(sc, m);
        }else if(choose.equals("U")){
            updateBook(sc, m);
        }
    }
}

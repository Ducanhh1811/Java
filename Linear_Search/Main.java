package Linear_Search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value, size;

        do{
            System.out.print("Enter size: ");
            size = sc.nextInt();
        }while(size < 0);
        
        do{
            System.out.print("Enter value: ");
            value = sc.nextInt();
        }while(value <= 0);

        linearSearch ls = new linearSearch(size, value);

        System.out.print("Array: ");
        ls.display();

        int pos = ls.search();
        if(pos == -1){
            System.out.println("\nNot found");
        }else{
            System.out.println("\nFound index: " + pos);
        }

        sc.close();
    }
}

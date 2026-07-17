package Binary_Search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size, value;

        do{
            System.out.print("Enter size: ");
            size = sc.nextInt();
        }while(size < 0);

        do{
            System.out.print("Enter value: ");
            value = sc.nextInt();
        }while(value < 0);
        
        binarySearch bs = new binarySearch(size);

        System.out.print("Array: ");
        bs.display();

        int pos = bs.search(value);
        if(pos == -1){
            System.out.println("\nNot found");
        }else{
            System.out.println("\nFound index: " + pos);
        }

        sc.close();
    }
}

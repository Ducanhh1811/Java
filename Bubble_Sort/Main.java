package Bubble_Sort;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        do{
            System.out.print("Enter size: ");
            size = sc.nextInt();
        }while(size < 0);

        bubbleSort s = new bubbleSort(size);
        s.display();
        s.sort();
        s.display();
        sc.close();
    }
}
package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> foods = new ArrayList<>();
        System.out.print("Enter the # food you world like: ");
        int numOfFood = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= numOfFood; i++){
            System.out.print("Enter food " + i + ": ");
            String food = sc.nextLine();
            foods.add(food);
        }   

        System.out.println(foods);

        sc.close();
    }
}

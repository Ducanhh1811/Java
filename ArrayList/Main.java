package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Coconut");

        // fruits.remove(3);
        // fruits.set(1, "Pineapple");


        System.out.println(fruits);
        System.out.println(fruits.get(2));
        System.out.println("SIze array: " + fruits.size());

        Collections.sort(fruits);
        System.out.println(fruits);
        System.out.println(); 
        
        for(String fruit : fruits){
            System.out.print(fruit + " ");
        }
    }
}

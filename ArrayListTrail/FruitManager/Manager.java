package FruitManager;

import java.util.ArrayList;

public class Manager {
    private ArrayList<Fruit> fruits;

    public Manager(){
        fruits = new ArrayList<>();
    }

    public ArrayList<Fruit> getFruit(){
        return fruits;
    }

    public void addFruit(Fruit f){
        fruits.add(f);
    }

    public int findFruit(String input){
        for(int i = 0; i < fruits.size(); i++){
            if(fruits.get(i).getFruit().equals(input)){
                return i;
            }
        }
        return -1;
    }
    
    public void removeFruit(String input){
        int index = findFruit(input);
        fruits.remove(index);
    }

    public void display(){
        for (Fruit f : fruits) {
            System.out.println("List: " + f + " ");
        }
    }
}   

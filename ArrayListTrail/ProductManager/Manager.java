package ProductManager;

import java.util.ArrayList;

public class Manager {
    private ArrayList<Product> products;

    public Manager(){
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProduct(){
        return products;
    }

    public void addProduct(Product p){
        for (Product existingProduct : products) {
            if (existingProduct.getName().equalsIgnoreCase(p.getName())) {
                throw new IllegalArgumentException("Product name already exists.");
            }
        }
        products.add(p);
    }

    public void display(){
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public int search(String input){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getName().equals(input)){
                return i;
            }
        }
        return -1;
    }

    public void searchProduct(String input){
        int index = search(input);
        if(index >= 0){
            System.out.println(input);
        }        
    }

    public boolean deleteProduct(String input){
        int index = search(input);
        if(index >= 0){
            products.remove(index);
            return true;
        }
        return false;
    }
}

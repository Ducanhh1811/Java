package ProductManager;

// Name, Price

public class Product {
    private String name;
    private double price;

    public Product(){}

    public Product(String name, double price){
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot empty.");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Price must >= 0");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ":   " + price;
    }        
}

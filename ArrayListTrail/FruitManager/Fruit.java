package FruitManager;

public class Fruit {
    private String fruit;
    
    public Fruit(){}

    public Fruit(String fruit){
        setFruit(fruit);
    }

    public String getFruit(){
        return fruit;
    }

    public void setFruit(String fruit){
        if(fruit == null || fruit.isEmpty()){
            throw new IllegalArgumentException("Fruit cannot empty.");
        }
        this.fruit = fruit; 
    }

    @Override
    public String toString() {
        return "[Fruit= " + fruit + " ]";
    }
}

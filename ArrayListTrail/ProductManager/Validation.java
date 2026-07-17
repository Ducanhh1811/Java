package ProductManager;

public class Validation {
    public static String validName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        return name.trim();
    }

    public static double validPrice(String priceStr){
        if(priceStr == null || priceStr.trim().isEmpty()){
            throw new IllegalArgumentException("Price cannot be empty.");
        }
        try{
            double price = Double.parseDouble(priceStr.trim());
            if(price <= 0){
                throw new IllegalArgumentException("Price must be a position double.");
            }
            return price;
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Price must be a valid double.");
        }
    }
}

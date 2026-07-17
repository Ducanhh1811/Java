package BookManager;

public class Validation {
    public static String validId(String id){
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("Id cannot be empty.");
        }
        return id.trim();
    }

    public static String validTitle(String title){
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        return title.trim();
    }

    public static String validAuthor(String author){
        if(author == null || author.isEmpty()){
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        return author.trim();
    }

    public static int validQuantity(String quantityStr){
        if(quantityStr == null || quantityStr.isEmpty()){
            throw new IllegalArgumentException("QuantityStr cannot be empty.");
        }
        try{
            int quantity = Integer.parseInt(quantityStr.trim());
            if(quantity < 0){
                throw new IllegalArgumentException("Quantity must be a positive integer.");
            }
            return quantity;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Quantity must be a valid int.");
        }
    }
}

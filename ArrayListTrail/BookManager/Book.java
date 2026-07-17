package BookManager;

public class Book {
    private String id;
    private String title;
    private String author;
    private int quantity;
    
    public Book(){}

    public Book(String id, String title, String author, int quantity){
        setAuthor(author);
        setId(id);
        setQuantity(quantity);
        setTitle(title);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("ID cannot be empty.");
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author == null || author.isEmpty()){
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", quantity=" + quantity + "]";
    }

}

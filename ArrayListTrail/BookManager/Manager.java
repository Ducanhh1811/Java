package BookManager;

import java.util.ArrayList;

public class Manager {
    private ArrayList<Book> books;

    public Manager(){
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBook(){
        return books;
    }

    public void add(Book b){
        for (Book existBook : books) {
            if(existBook.getId().equalsIgnoreCase(b.getId())){
                throw new IllegalArgumentException("Book id already exist.");
            }
        }
        books.add(b);
    }

    public void display(){
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public int searchIndex(String input){
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getId().equalsIgnoreCase(input)){
                return i;
            }
        }
        return -1;
    }

    public Book findBookById(String input){
        int index = searchIndex(input);
        if(index >= 0){
            return books.get(index);
        }
        return null;
    }

    public boolean update(String input, String title, String author, int quantity){
        int index = searchIndex(input);
        if(index >= 0){
            Book b = books.get(index);
            b.setTitle(title);
            b.setAuthor(author);
            b.setQuantity(quantity);
            return true;
        }
        return false;
    }

    public boolean delete(String input){
        int index = searchIndex(input);
        if(index >= 0){
            books.remove(index);
            return true;
        }
        return false;
    }
}

package dal;

public class DBTest {

    public static void main(String[] args) {
        DBContext db = new DBContext();

        if (db.connection != null) {
            System.out.println("DB CONNECTED!");
        } else {
            System.out.println("DB CONNECTION FAILED!");
        }
    }
}
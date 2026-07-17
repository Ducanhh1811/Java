package ProductManager;

import java.util.Scanner;

// Khi thêm sản phẩm, chương trình cần kiểm tra dữ liệu nhập vào: tên sản phẩm 
// không được để trống, không được trùng với sản phẩm đã tồn tại trong danh sách; 
// giá sản phẩm phải là số hợp lệ và lớn hơn 0. Khi hiển thị, chương trình in ra 
// toàn bộ danh sách sản phẩm. Khi tìm kiếm, người dùng nhập tên sản phẩm và
//  chương trình sẽ hiển thị thông tin sản phẩm nếu tìm thấy, ngược lại thông báo
//  không tồn tại. Khi xóa sản phẩm, chương trình yêu cầu nhập tên sản phẩm cần xóa,
//  nếu sản phẩm có trong danh sách thì thực hiện xóa, nếu không thì thông báo lỗi.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
        sc.close();
    }

    public static void menu(Scanner sc) {
        Manager m = new Manager();
        while (true) {
            System.out.println();
            System.out.println("========== Mennu ==========");
            System.out.println("1. Add Product.");
            System.out.println("2. Display Product.");
            System.out.println("3. Search Product");
            System.out.println("4. Delete Product.");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addProduct(sc, m);
                    break;
                case 2:
                    m.display();
                    break;
                case 3:
                    searchProduct(sc, m);
                    break;
                case 4:
                    deleteProduct(sc, m);
                    break;
                case 5:
                    System.out.println("GoodBye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    public static void addProduct(Scanner sc, Manager m){
        System.out.println();
        System.out.println("====== Product Info ======");
        while(true){
            try{
                System.out.print("Enter name: ");
                String name = Validation.validName(sc.nextLine());

                System.out.print("Enter price: ");
                double price = Validation.validPrice(sc.nextLine());

                m.addProduct(new Product(name, price));
                System.out.println("Add product successfully.");
                return;
            }catch(IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void deleteProduct(Scanner sc, Manager m) {
        System.out.print("Enter name: ");
        String name = Validation.validName(sc.nextLine());

        boolean delete = m.deleteProduct(name);
        if (delete) {
            System.out.println("Delete successfully.");
        } else {
            System.out.println("Delete fail.");
        }
    }

    public static void searchProduct(Scanner sc, Manager m) {

        System.out.print("Enter name: ");
        String name = Validation.validName(sc.nextLine());

        m.searchProduct(name);
    }
}
